package com.springBoot.webFlux.kitchen.service

import com.springBoot.webFlux.kitchen.domain.Dish
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.*

@Service
class KitchenService {

    fun getDish() :Flux<Dish> {
        return Flux.generate<Dish>{ sink -> sink.next(randomDish())}.delayElements(Duration.ofMillis(250))
    }

    private fun randomDish() : Dish {
        return menu[picker.nextInt(menu.size)]
    }

    private val menu = listOf(
        Dish("Sesame chicken"),
        Dish("Lo mein noodles, plain"),
        Dish("Sweet & sour beef"),
    )

    private val picker = Random()
}