package com.inxmail.clicktracker.entity

import com.fasterxml.jackson.annotation.JsonFormat

/**
 * Created by fewi on 18.06.2015.
 */
class Url {
    private long id
    private String slug
    private String longURL

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ")
    private Date createdAt

    List<ClickData> clickData

    Url() {
    }

    long getId() {
        return id
    }

    void setId(long id) {
        this.id = id
    }

    String getSlug() {
        return slug
    }

    void setSlug(String slug) {
        this.slug = slug
    }

    String getLongURL() {
        return longURL
    }

    void setLongURL(String longURL) {
        this.longURL = longURL
    }

    Date getCreatedAt() {
        return createdAt
    }

    void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt
    }

    List<ClickData> getClickData() {
        return clickData
    }

    void setClickData(List<ClickData> clickData) {
        this.clickData = clickData
    }
}
