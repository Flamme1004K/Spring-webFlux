package com.springBoot.webFlux.cart.domain

import org.springframework.data.annotation.Id

data class Item(
    @Id var id: String? = null,
    var name: String,
    var price : Double
) {
    constructor(name : String, price : Double) :this(id = null, name = name, price = price)
}