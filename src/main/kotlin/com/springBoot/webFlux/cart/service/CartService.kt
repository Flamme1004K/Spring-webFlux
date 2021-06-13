package com.springBoot.webFlux.cart.service

import com.springBoot.webFlux.cart.domain.*
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CartService(private val itemRepository: ItemRepository, private val cartRepository: CartRepository) {

    fun addToCart(cartId : String, id : String) :Mono<Cart> =
        cartRepository.findById(cartId)
            .defaultIfEmpty(Cart(cartId))
            .flatMap { cart ->
                cart.cartItems.stream()
                    .filter { (item) -> item.id == id }
                    .findAny()
                    .map { cartItem: CartItem -> cartItem.increment()
                        Mono.just(cart) }
                    .orElseGet {
                        itemRepository.findById(id).map { item ->
                            CartItem(item)
                        }
                            .map {
                                    cartItem: CartItem -> cart.cartItems.add(cartItem)
                                cart
                            }
                    }
            }.flatMap { cart: Cart -> cartRepository.save(cart) }
}