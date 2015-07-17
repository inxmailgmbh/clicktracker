package com.inxmail.clicktracker.entity

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="urlId")
    long id

    @NotNull
    String slug

    @NotNull
    String longUrl

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ")
    Date createdAt

}