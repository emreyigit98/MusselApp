package com.emreyigit98.musselsapp.presentation.screen.result_screen

import androidx.lifecycle.ViewModel
import com.emreyigit98.musselsapp.data.local.model.MusselDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ResultScreenViewModel : ViewModel() {
    private val _resultScreenState = MutableStateFlow(ResultScreenState())
    val resultScreenState: StateFlow<ResultScreenState> = _resultScreenState.asStateFlow()


    fun addCustomerName(customerName: String) = _resultScreenState.update { state ->
        state.copy(
            customerName = customerName
        )
    }

    fun addMusselName(musselName: String) = _resultScreenState.update { state ->
        state.copy(
            musselName = musselName
        )
    }

    fun addMusselPrice(musselPrice: Double) = _resultScreenState.update { state ->
        state.copy(
            musselPrice = musselPrice
        )
    }

    fun addMusselQuantity(musselQuantity: Int) = _resultScreenState.update { state ->
        state.copy(
            musselQuantity = musselQuantity
        )
    }

    fun addDate(date: String) = _resultScreenState.update { state ->
        state.copy(
            date = date
        )
    }

    fun getMusselDetail(): MusselDetail {
        return MusselDetail(
            customerName = _resultScreenState.value.customerName,
            musselName = _resultScreenState.value.musselName,
            musselPrice = _resultScreenState.value.musselPrice,
            musselQuantity = _resultScreenState.value.musselQuantity,
            musselResultPrice = _resultScreenState.value.musselResultPrice,
            date = _resultScreenState.value.date
        )
    }
}