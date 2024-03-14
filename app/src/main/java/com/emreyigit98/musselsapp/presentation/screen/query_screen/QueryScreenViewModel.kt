package com.emreyigit98.musselsapp.presentation.screen.query_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreyigit98.musselsapp.data.local.model.MusselDetail
import com.emreyigit98.musselsapp.domain.repo.MusselAppDatabaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QueryScreenViewModel @Inject constructor(
    private val musselAppDatabaseImpl: MusselAppDatabaseImpl
): ViewModel() {

    private val _responseList = mutableStateOf<List<MusselDetail>>(emptyList())
    val responseList : State<List<MusselDetail>> = _responseList

    init {
        allMusselDetailList()
    }

    fun addMusselDetail(musselDetail: MusselDetail) = viewModelScope.launch(Dispatchers.Default) {
        musselAppDatabaseImpl.addMusselDetailRepo(musselDetail)
    }

    fun allMusselDetailList() = viewModelScope.launch() {
        _responseList.value = musselAppDatabaseImpl.allMusselDetailRepo()
    }

    fun getDetailOrderId(id : Int) = _responseList.value.firstOrNull { it.id == id }

}