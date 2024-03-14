package com.emreyigit98.musselsapp.presentation.screen.customer_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emreyigit98.musselsapp.data.remote.model.CustomersModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun CustomerScreen(
    customerScreenViewModel: CustomerScreenViewModel,
    customerItemList: List<CustomersModel>,
    onSelectedItem: (String) -> Unit,
    onNextScreen :() -> Unit
) {
    val refreshState by customerScreenViewModel.refreshState.collectAsState()
    var selectedItem by remember { mutableStateOf("") }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = refreshState),
        onRefresh = {
            customerScreenViewModel.refresh()
            //customerScreenViewModel.allCustomersName()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(customerItemList) { customerModel ->
                Card(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        10.dp
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                            .selectable(selected = selectedItem == customerModel.customerName) {
                                onSelectedItem(customerModel.customerName)
                                selectedItem = customerModel.customerName
                                onNextScreen()
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedItem == customerModel.customerName,
                            onClick = {
                                selectedItem = customerModel.customerName
                                onSelectedItem(customerModel.customerName)
                            }
                        )
                        Spacer(modifier = Modifier.padding(start = 20.dp))
                        Text(
                            text = customerModel.customerName,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.DarkGray,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
    }
}
