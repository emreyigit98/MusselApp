package com.emreyigit98.musselsapp.presentation.screen.mussel_screen

import com.emreyigit98.musselsapp.data.remote.model.MusselsModel

sealed interface MusselScreenUiState {
    data class Success(val responseList : List<MusselsModel>) : MusselScreenUiState
    data object Error : MusselScreenUiState
    data object Loading : MusselScreenUiState
}