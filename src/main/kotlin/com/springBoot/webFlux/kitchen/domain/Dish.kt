package com.springBoot.webFlux.kitchen.domain

data class Dish(val description: String, var delivered : Boolean = false) {

    companion object {
        fun deliver(dish :Dish) : Dish{
            val deliveredDish = Dish(dish.description)
            deliveredDish.delivered = true
            return deliveredDish
        }
    }

    override fun toString(): String {
        return "Dish(description='$description', delivered=$delivered)"
    }

}
