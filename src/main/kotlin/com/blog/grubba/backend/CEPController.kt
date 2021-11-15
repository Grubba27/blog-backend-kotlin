package com.blog.grubba.backend

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.net.URL

@RestController
class CEPController {

    @GetMapping("/cep/{slug}")
    fun getCoin(@PathVariable slug: String): String? {
        // get
        val json = try {
            URL("https://cep.awesomeapi.com.br/json/$slug").readText()
        } catch (e: Exception) {
            return e.message
        }
        return json
    }
}