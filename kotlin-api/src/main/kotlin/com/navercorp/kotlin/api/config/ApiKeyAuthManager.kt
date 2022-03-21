package com.navercorp.kotlin.api.config

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication

class ApiKeyAuthManager : AuthenticationManager {
    private val apiValueSet: Set<String> = setOf(
        "valueA", "valueB", "value"
    )

    @Override
    override fun authenticate(authentication: Authentication?): Authentication {
        if (authentication == null) {
            throw BadCredentialsException("Authentication is null")
        }

        val principal = authentication.principal
        if (!apiValueSet.contains(principal)) {
            throw BadCredentialsException("error")
        }
        authentication.isAuthenticated = true
        return authentication
    }
}
