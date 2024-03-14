package com.emreyigit98.musselsapp.presentation.screen.query_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope

@Composable
fun QueryScreen(
    queryScreenViewModel: QueryScreenViewModel,
    detailId : (Int) -> Unit
) {
    val responseList by queryScreenViewModel.responseList
 
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        items(responseList) { musselDetail ->
            Card(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    10.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .clickable {
                            detailId(musselDetail.id)
                        },
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = musselDetail.customerName,
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = Color.LightGray,
                        )
                    )
                    Text(
                        text = musselDetail.date,
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = Color.DarkGray,
                        )
                    )
                }
            }
        }
    }
}
