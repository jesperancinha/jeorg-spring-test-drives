package org.jesperancinha.std

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("movies")
class MovieLinesController {

    @GetMapping(path = ["thesoundofmusic"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getQuotes() : String {
        return "The hills are alive with the sound of music";
    }
}