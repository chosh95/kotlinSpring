package com.navercorp.kotlin.api.config

import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JasyptConfig {

    @Value("\${jasypt.encryptor.password}")
    lateinit var password: String;

    @Bean("jasyptEncryptor")
    fun jasyptEncryptor() = PooledPBEStringEncryptor().also {
        it.setConfig(SimpleStringPBEConfig().also { conf ->
            conf.poolSize = 1
            conf.password = password
            conf.stringOutputType = "base64"
            conf.keyObtentionIterations = 1000
            conf.provider = BouncyCastleProvider()
            conf.algorithm = "PBEWithSHA256And128BitAES-CBC-BC"
            conf.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator")
        })
    }
}
