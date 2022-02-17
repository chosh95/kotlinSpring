package com.navercorp.kotlin.api.controller

import com.navercorp.kotlin.domain.mapper.UserMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController(val userMapper: UserMapper) {

    @GetMapping("/")
    fun home(): String {
        return "Hello World"
    }
}
