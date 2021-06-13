package com.springBoot.webFlux.cart.domain

import org.springframework.data.annotation.Id

data class Cart(
    @Id val id : String,
    val cartItems : MutableList<CartItem>
) {
    constructor(id : String) :this(id = id, cartItems = arrayListOf())
}
