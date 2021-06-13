package com.springBoot.webFlux.cart.presentation

import com.springBoot.webFlux.cart.domain.*
import com.springBoot.webFlux.cart.service.CartService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.reactive.result.view.Rendering
import reactor.core.publisher.Mono


@Controller
class HomeController(private val itemRepository: ItemRepository, private val cartRepository: CartRepository, private val cartService: CartService) {

    @GetMapping
    fun home() : Mono<Rendering> =
        Mono.just(Rendering.view("home.html")
            .modelAttribute("items", itemRepository.findAll())
            .modelAttribute("cart", cartRepository.findById("My Cart").defaultIfEmpty(Cart("My Cart")))
            .build()
        )


    @PostMapping("/add/{id}")
    fun addToCart(@PathVariable id: String): Mono<String> =
        cartService.addToCart("My Cart", id).thenReturn("redirect:/")

}