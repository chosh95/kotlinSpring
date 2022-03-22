package com.navercorp.kotlin.api.config

import com.navercorp.kotlin.api.filter.ApiKeyAuthFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Order(1)
@Configuration
@EnableWebSecurity
class ApiSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .antMatcher("/api/**")
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilter(apiKeyAuthFilter())
            .authorizeRequests().anyRequest().authenticated()
    }

    @Bean
    fun apiKeyAuthFilter(): ApiKeyAuthFilter {
        return ApiKeyAuthFilter().apply {
            setAuthenticationManager(ApiKeyAuthManager())
        }
    }
}
