package com.emreyigit98.musselsapp.presentation.screen.order_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emreyigit98.musselsapp.presentation.screen.query_screen.QueryScreenViewModel

@Composable
fun OrderScreen(
    queryScreenViewModel: QueryScreenViewModel,
    id : Int
) {

    val getId = requireNotNull(queryScreenViewModel.getDetailOrderId(id))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.padding(horizontal = 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                20.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Name",
                    color = Color.LightGray
                )
                Text(
                    text = getId.customerName,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color(0XFF227172),
                        fontWeight = FontWeight.Bold
                    )
                )
                Divider()
                Text(
                    text = "Boy",
                    color = Color.LightGray
                )
                Text(
                    text = getId.musselName,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color(0XFF227172),
                        fontWeight = FontWeight.Bold
                    )
                )
                Divider()
                Text(
                    text = "Price",
                    color = Color.LightGray
                )
                Text(
                    text = "${getId.musselPrice} \u20BA",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color(0XFF227172),
                        fontWeight = FontWeight.Bold
                    )
                )
                Divider()
                Text(
                    text = "Quantity",
                    color = Color.LightGray
                )
                Text(
                    text = getId.musselQuantity.toString(),
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color(0XFF227172),
                        fontWeight = FontWeight.Bold
                    )
                )
                Divider()
                Text(
                    text = "Result Price",
                    color = Color.LightGray
                )
                Text(
                    text = "${getId.musselResultPrice} \u20BA",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color(0XFF227172),
                        fontWeight = FontWeight.Bold
                    )
                )
                Divider()
                Text(
                    text = "Date",
                    color = Color.LightGray
                )
                Text(
                    text = getId.date,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color(0XFF227172),
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}