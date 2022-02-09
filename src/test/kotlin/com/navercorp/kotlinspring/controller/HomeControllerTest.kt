package com.navercorp.kotlinspring.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
internal class HomeControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun homeTest() {
        val result = restTemplate.getForEntity<String>("/");
        assertThat(result.statusCodeValue).isEqualTo(200);
        assertThat(result.statusCode).isEqualTo(HttpStatus.OK);
        assertThat(result.body).isEqualTo("Hello World");
    }
}