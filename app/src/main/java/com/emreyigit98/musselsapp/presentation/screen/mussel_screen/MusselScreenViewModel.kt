package com.emreyigit98.musselsapp.presentation.screen.mussel_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreyigit98.musselsapp.domain.repo.NetworkApiImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MusselScreenViewModel @Inject constructor(
    private val networkApiImpl: NetworkApiImpl
) : ViewModel() {

    var musselScreenUiState: MusselScreenUiState by mutableStateOf(MusselScreenUiState.Loading)
        private set

    private val _refreshState = MutableStateFlow(false)
    val refreshState: StateFlow<Boolean> = _refreshState.asStateFlow()

    fun refresh() = viewModelScope.launch {
        _refreshState.emit(true)
        delay(1500)
        _refreshState.emit(false)
        allMussels()
    }

    fun allMussels() = viewModelScope.launch {
        musselScreenUiState = MusselScreenUiState.Loading
        musselScreenUiState = try {
            MusselScreenUiState.Success(networkApiImpl.getAllMusselRepo())
        } catch (exception: IOException) {
            MusselScreenUiState.Error
        } catch (exception: HttpException) {
            MusselScreenUiState.Error
        }
    }
}

