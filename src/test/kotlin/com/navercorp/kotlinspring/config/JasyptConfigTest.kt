package com.navercorp.kotlinspring.config

import com.navercorp.kotlinspring.KotlinSpringApplication
import org.assertj.core.api.Assertions.assertThat
import org.jasypt.encryption.StringEncryptor
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.PropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [KotlinSpringApplication::class])
@PropertySource(value = ["application.properties"])
class JasyptConfigTest {

    @Autowired
    @Qualifier("jasyptEncryptor")
    lateinit var stringEncryptor: StringEncryptor

    @Test
    fun encrypt() {
        assertThat(stringEncryptor).isNotNull
        val text = "chopassword"
        println("ENC(${stringEncryptor.encrypt(text)})")
    }
}
