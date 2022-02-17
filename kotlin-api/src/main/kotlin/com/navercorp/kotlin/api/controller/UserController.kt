package com.navercorp.kotlin.api.controller

import com.navercorp.kotlin.domain.dto.UserRequest
import com.navercorp.kotlin.domain.mapper.UserMapper
import com.navercorp.kotlin.domain.model.User
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class UserController(val userMapper: UserMapper) {

    @GetMapping("user")
    fun selectUser(@RequestParam("id") id: Int): User {
        return userMapper.selectUser(id)
    }

    @PostMapping(value = ["user"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun insertUser(@RequestBody user: UserRequest) {
        println(user)
        return userMapper.insertUser(user)
    }
}
