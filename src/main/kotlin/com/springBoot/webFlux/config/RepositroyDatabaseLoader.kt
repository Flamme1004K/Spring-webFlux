package com.springBoot.webFlux.config

import com.springBoot.webFlux.cart.domain.Item
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Component

@Component
class RepositroyDatabaseLoader {
    @Bean
    fun initialize(mongo : MongoOperations) :CommandLineRunner {
        return CommandLineRunner{
            mongo.save(Item("Alf alarm clock", 19.99))
            mongo.save(Item("Smurf TV tray", 24.99))
        }
    }
}