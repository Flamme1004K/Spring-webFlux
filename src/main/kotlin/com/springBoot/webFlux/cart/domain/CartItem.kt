package com.springBoot.webFlux.cart.domain

data class CartItem(
    val item : Item,
    var quantity : Int
) {
    constructor(item: Item) : this(item = item, quantity = 1)
    fun increment() {
        quantity++
    }
}
