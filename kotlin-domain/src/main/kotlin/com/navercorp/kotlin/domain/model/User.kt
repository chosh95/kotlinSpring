package com.navercorp.kotlin.domain.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val age: Int,
    val gender: String,
)
