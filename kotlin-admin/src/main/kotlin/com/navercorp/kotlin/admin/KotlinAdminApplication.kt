package com.navercorp.kotlin.admin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinAdminApplication

fun main(args: Array<String>) {
    runApplication<KotlinAdminApplication>(*args)
}
