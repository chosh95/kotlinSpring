package com.navercorp.kotlin.api.controller

import com.navercorp.kotlin.domain.mapper.UserMapper
import com.navercorp.kotlin.domain.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController(val userMapper: UserMapper) {

    @GetMapping("/")
    fun home(): String {
        return "Hello World"
    }

    @GetMapping("/user")
    fun selectUser(): User {
        return userMapper.selectUser("1");
    }
}
