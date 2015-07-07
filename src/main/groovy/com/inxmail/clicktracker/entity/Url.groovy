package com.inxmail.clicktracker.entity

import com.fasterxml.jackson.annotation.JsonFormat

class Url {
    long id
    String slug
    String longUrl

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ")
    Date createdAt


}