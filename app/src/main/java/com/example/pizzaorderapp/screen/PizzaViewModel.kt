package com.example.pizzaorderapp.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(PizzaUiState())
    val state = _state.asStateFlow()

    fun onClick(pizzaSize: PizzaSize) {
        _state.update {
            it.copy(size = pizzaSize)
        }
        Log.e("viewModel", "Pizza:${state.value.size.name} ")
    }

    fun onClickIsSelectedB() {
        _state.value = _state.value.copy(isSelectedB = !state.value.isSelectedB)
    }

    fun onClickIsSelectedA() {
        _state.value = _state.value.copy(isSelectedA = !state.value.isSelectedA)
    }

    fun onClickIsSelectedD() {
        _state.value = _state.value.copy(isSelectedD = !state.value.isSelectedD)
    }

    fun onClickIsSelectedN() {
        _state.value = _state.value.copy(isSelectedN = !state.value.isSelectedN)
    }
    fun onClickIsSelectedS() {
        _state.value = _state.value.copy(isSelectedS = !state.value.isSelectedS)
    }



}