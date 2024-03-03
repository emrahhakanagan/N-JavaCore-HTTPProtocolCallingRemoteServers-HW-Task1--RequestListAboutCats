package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

class CatFact {
    private String id;
    private String text;
    private String type;
    private String user;
    private Integer upvotes;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("upvotes")
    public Integer getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "CatFact{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", upvotes=" + upvotes +
                '}';
    }
}
