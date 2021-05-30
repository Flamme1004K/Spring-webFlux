package com.springBoot.webFlux.kitchen.presentation

import com.springBoot.webFlux.kitchen.domain.Dish
import com.springBoot.webFlux.kitchen.service.KitchenService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class KitchenController(private val kitchen: KitchenService) {

    @GetMapping(value = ["/server"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun serveDishes() : Flux<Dish> {
        return kitchen.getDish()
    }

    @GetMapping(value = ["/server-dishes"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun deliverDishes() : Flux<Dish> {
        return  kitchen.getDish().map { dish -> Dish.deliver(dish)}
    }

}