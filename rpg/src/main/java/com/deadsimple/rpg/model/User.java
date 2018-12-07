package com.deadsimple.rpg.model;

import com.google.common.collect.Lists;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Document
public class User implements UserDetails {
    @Id
    String id;

    String username;

    String password;

    Boolean isAccountNonLocked;

    Boolean isAccountNonExpired;

    Boolean isCredentialsNonExpired;

    Boolean isEnabled;

    @DBRef
    GameState gameState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    @Transient
    // TODO implement ADMIN role
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
