package com.navercorp.kotlin.api.filter

import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter
import javax.servlet.http.HttpServletRequest

const val API_KEY_HEADER_NAME = "Authentication";

class ApiKeyAuthFilter : AbstractPreAuthenticatedProcessingFilter() {

    override fun getPreAuthenticatedPrincipal(request: HttpServletRequest?): Any {
        if (request != null) {
            return request.getHeader(API_KEY_HEADER_NAME)
        }
        throw BadCredentialsException("Request is null")
    }

    // credential(비밀번호)은 api key filter 에서는 사용하지 않는다.
    override fun getPreAuthenticatedCredentials(request: HttpServletRequest?): Any {
        return "N/A"
    }
}
