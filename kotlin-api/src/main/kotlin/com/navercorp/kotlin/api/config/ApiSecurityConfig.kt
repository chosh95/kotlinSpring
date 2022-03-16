package com.navercorp.kotlin.api.config

import com.navercorp.kotlin.api.filter.ApiKeyAuthFilter
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
@EnableWebSecurity
@Order(1)
class ApiSecurityConfig : WebSecurityConfigurerAdapter {

    constructor()

    val filter: ApiKeyAuthFilter = ApiKeyAuthFilter()

    @Override
    override fun configure(http: HttpSecurity) {
        filter.setAuthenticationManager(ApiKeyAuthManager())
        http
            .cors().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilter(filter).authorizeRequests().anyRequest().authenticated()
            .and().formLogin().disable()
    }
}
