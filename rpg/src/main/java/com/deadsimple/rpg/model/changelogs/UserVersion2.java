package com.deadsimple.rpg.model.changelogs;

import com.deadsimple.rpg.model.GameState;
import com.deadsimple.rpg.model.User;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.DBRef;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@ChangeLog
public class UserVersion2 {
    @ChangeSet(order = "001", id = "makeUserImplementUserDetails", author = "me")
    public void makeUserImplementUserDetails(MongoTemplate template) {
        Query query = new Query();
        Update update = new Update();

        update.rename("email", "username");
        update.set("isAccountNonLocked", true);
        update.set("isAccountNonExpired", true);
        update.set("isCredentialsNonExpired", true);
        update.set("isEnabled", true);

        template.findAndModify(query, update, User.class);
    }

    @ChangeSet(order = "002", id = "createGamestateForTestUser", author = "me")
    public void createGamestateForTestUser(MongoTemplate template) {
        GameState state = GameState.initNewPlayer();
        template.save(state);

        Query query = new Query();
        Update update = new Update();

        update.set("gameState", new DBRef("gameState", state.getId()));

        template.findAndModify(query, update, User.class);
    }
}
