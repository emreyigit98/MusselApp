package com.emreyigit98.musselsapp.presentation.screen.customer_screen

import com.emreyigit98.musselsapp.data.remote.model.CustomersModel

sealed interface CustomerScreenUiState {
    data class Success(val responseList : List<CustomersModel>) : CustomerScreenUiState
    data object Loading : CustomerScreenUiState
    data object Error : CustomerScreenUiState
}