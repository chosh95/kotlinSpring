package com.navercorp.kotlin.domain.dto

data class UserRequest(
    val name: String,
    val email: String,
    val password: String,
    val age: Int,
    val gender: String
)
