package com.inxmail.clicktracker.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class RedirectController {
    @RequestMapping(value="/{slug}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Void> redirect (@PathVariable("slug") String slug) {
        ResponseEntity.status(HttpStatus.FOUND).header("Location","https://www.google.de/?gws_rd=ssl#q="+slug).build()

    }
}
