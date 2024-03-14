package com.emreyigit98.musselsapp.presentation.screen.result_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import java.time.LocalDate

@Composable
fun ResultScreen(
    resultScreenState: ResultScreenState,
    onClick : () -> Unit,
    localDate : String
) {
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
                    text = resultScreenState.customerName,
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
                    text = resultScreenState.musselName,
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
                    text = "${resultScreenState.musselPrice} \u20BA",
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
                    text = resultScreenState.musselQuantity.toString(),
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
                    text = "${resultScreenState.musselResultPrice} \u20BA",
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
                    text = localDate,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color(0XFF227172),
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
        Spacer(
            modifier = Modifier.padding(top = 30.dp)
        )
        Button(
            onClick = onClick , colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF227172)
            ),
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text(text = "Save Record")
        }
    }
}
