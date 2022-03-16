package com.navercorp.kotlin.api.filter

import com.navercorp.kotlin.api.config.ApiKeyAuthManager
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter
import javax.servlet.http.HttpServletRequest

class ApiKeyAuthFilter : AbstractPreAuthenticatedProcessingFilter {

    constructor() {
        this.setAuthenticationManager(ApiKeyAuthManager())
    }

    var principalRequestHeader: String = "Authentication"


    @Override
    override fun getPreAuthenticatedPrincipal(request: HttpServletRequest?): Any {
        if (request != null) {
            return request.getHeader(principalRequestHeader)
        }
        return ""
    }

    @Override
    override fun getPreAuthenticatedCredentials(request: HttpServletRequest?): Any {
        return "N/A"
    }
}
