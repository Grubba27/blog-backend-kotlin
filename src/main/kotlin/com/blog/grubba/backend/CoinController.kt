package com.blog.grubba.backend

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.net.URL

@RestController
class CoinController {

    @GetMapping("/coin/{slug}")
    fun getCoin(@PathVariable slug: String): String {
        val coinType = when (slug) {
            "dollar" -> "USD"
            "bitcoin" -> "BTC"
            else -> "EUR"
        }
        // get
        return URL("https://economia.awesomeapi.com.br/last/$coinType-BRL").readText()
    }

}