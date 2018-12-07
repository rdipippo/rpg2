package com.deadsimple.rpg.model.embedded;

import java.beans.Transient;

public class Message {
    String message;

    String type;

    public Message(String message, MessageType type) {
        this.message = message;
        this.type = type.name();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    @Transient
    public void setType(MessageType type) {
        this.type = type.name();
    }

    private void setType(String type) {
        this.type = type;
    }
}
