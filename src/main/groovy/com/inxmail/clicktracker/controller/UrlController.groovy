package com.inxmail.clicktracker.controller

import com.inxmail.clicktracker.entity.Url
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class UrlController {
    @RequestMapping(value="/api/url", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> registerUrl (@RequestBody Url url) {
        ResponseEntity.created(new URI("http://localhost:8989/random-short-code")).build()

    }

    @RequestMapping(value="/api/url", method = RequestMethod.GET)
    @ResponseBody
    public Url getData (@RequestParam(value = "slug") String slug) {
        def url = new Url()
        url.id = 1
        url.longURL = "https://url.to.something/"
        url.slug = slug
        url.createdAt = new Date()

        url
    }

}
