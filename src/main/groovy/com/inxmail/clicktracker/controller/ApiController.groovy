package com.inxmail.clicktracker.controller

import com.inxmail.clicktracker.entity.PostUrl
import com.inxmail.clicktracker.entity.Url
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by fewi on 18.06.2015.
 */
@Controller
class ApiController {
    @RequestMapping(value="/api/url", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> registerUrl (@RequestBody PostUrl url) {

        return ResponseEntity.status(HttpStatus.CREATED).header("Location","http://localhost:8989/<random-short-code>").build();

    }

    @RequestMapping(value="/api/url", method = RequestMethod.GET)
    @ResponseBody
    public Url getData (@RequestParam(value = "slug") String slug) {
        Url url = new Url();
        url.setId(1)
        url.setLongURL("https://url.to.something/")
        url.setSlug(slug)
        url.setCreatedAt(new Date())

        return url
    }


}
