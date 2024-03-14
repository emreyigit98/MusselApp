package com.emreyigit98.musselsapp.presentation.screen.mussel_screen

import androidx.compose.runtime.Composable
import com.emreyigit98.musselsapp.presentation.component.ErrorScreen
import com.emreyigit98.musselsapp.presentation.component.LoadingScreen

@Composable
fun MainMusselScreen(
    musselScreenUiState: MusselScreenUiState,
    musselScreenViewModel: MusselScreenViewModel,
    onSelectedItem: (price: Double, name: String) -> Unit,
    onRefresh: () -> Unit,
    onNextScreen : () -> Unit
) {
    when (musselScreenUiState) {
        MusselScreenUiState.Error -> ErrorScreen(
            onRefresh = onRefresh
        )

        MusselScreenUiState.Loading -> LoadingScreen()

        is MusselScreenUiState.Success -> MusselScreen(musselScreenViewModel = musselScreenViewModel,
            onSelectItem = { price, name ->
                onSelectedItem(price, name)
            },
            musselItemList = musselScreenUiState.responseList, onNextScreen = onNextScreen
        )
    }
}