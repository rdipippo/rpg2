package com.deadsimple.rpg.model.changelogs;

import com.deadsimple.rpg.model.GameState;
import com.deadsimple.rpg.model.User;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@ChangeLog
public class GameStateVersion2 {
    @ChangeSet(order = "003", id = "addTurnsField", author = "me")
    public void addTurnsField(MongoTemplate template) {
        Query query = new Query();
        Update update = new Update();

        update.set("turns", 40);

        template.findAndModify(query, update, GameState.class);
    }
}
