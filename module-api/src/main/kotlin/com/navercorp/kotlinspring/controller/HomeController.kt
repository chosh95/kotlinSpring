package com.navercorp.kotlinspring.controller

import com.navercorp.kotlinspring.Model.Tmp
import com.navercorp.kotlinspring.repository.TmpRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @Autowired
    lateinit var tmpRepository: TmpRepository

    @GetMapping("/")
    fun home(): String {
        return "Hello World"
    }

    @GetMapping("/all")
    fun selectAll(): List<Tmp> {
        return tmpRepository.findAll();
    }
}
