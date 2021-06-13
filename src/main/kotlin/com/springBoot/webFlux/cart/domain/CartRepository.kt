package com.springBoot.webFlux.cart.domain

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CartRepository : ReactiveCrudRepository<Cart, String> {
}