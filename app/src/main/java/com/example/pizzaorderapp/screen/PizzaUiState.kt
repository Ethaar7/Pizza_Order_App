package com.example.pizzaorderapp.screen


data class PizzaUiState(
    val size: PizzaSize = PizzaSize.S,
    val isSelectedB:Boolean  = false,
    val isSelectedA: Boolean = false,
    val isSelectedS: Boolean = false,
    val isSelectedN: Boolean = false,
    val isSelectedD: Boolean = false,
    )

enum class PizzaSize(
) {
    L,
    M,
    S
}

