package com.navercorp.kotlin.api.config

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.Authentication

class ApiKeyAuthManager : AuthenticationManager {
    private val testKey: String = "test"

    @Override
    override fun authenticate(authentication: Authentication?): Authentication? {
        var principal = authentication?.principal
        if (testKey != principal) {
            throw Exception("error")
        }
        authentication?.isAuthenticated = true
        return authentication
    }
}
