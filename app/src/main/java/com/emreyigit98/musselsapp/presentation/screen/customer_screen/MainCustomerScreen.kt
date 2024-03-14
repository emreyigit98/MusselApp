package com.emreyigit98.musselsapp.presentation.screen.customer_screen

import androidx.compose.runtime.Composable
import com.emreyigit98.musselsapp.data.remote.model.CustomersModel
import com.emreyigit98.musselsapp.presentation.component.ErrorScreen
import com.emreyigit98.musselsapp.presentation.component.LoadingScreen
import com.google.accompanist.swiperefresh.SwipeRefreshState

@Composable
fun MainCustomerScreen(
    customerScreenUiState: CustomerScreenUiState,
    customerScreenViewModel: CustomerScreenViewModel,
    onSelected: (String) -> Unit,
    onRefresh: () -> Unit,
    onNextScreen :() -> Unit
) {

    when (customerScreenUiState) {
        CustomerScreenUiState.Error -> ErrorScreen(
            onRefresh = onRefresh
        )

        CustomerScreenUiState.Loading -> LoadingScreen()

        is CustomerScreenUiState.Success -> CustomerScreen(customerScreenViewModel = customerScreenViewModel,
            customerItemList = customerScreenUiState.responseList,
            onSelectedItem = { item ->
                onSelected(item)
            },
            onNextScreen = onNextScreen
        )
    }
}