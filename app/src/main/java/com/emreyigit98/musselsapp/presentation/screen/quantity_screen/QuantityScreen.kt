package com.emreyigit98.musselsapp.presentation.screen.quantity_screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun QuantityScreen(
    onClick: () -> Unit,
    value: String,
    onValueChange: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.padding(horizontal = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                100.dp
            )
        ) {
            Text(
                text = "Enter Quantity",
                style = TextStyle(
                    fontSize = 30.sp,
                    color = Color(0XFF227172),
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.padding(start = 10.dp, top = 20.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                OutlinedTextField(
                    value = value,
                    onValueChange = onValueChange,
                    placeholder = {
                        Text(text = "Quantity")
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0XFF227172),
                        focusedBorderColor = Color(0XFF227172)
                    ),
                    modifier = Modifier.fillMaxWidth(1f)
                )
                Button(
                    onClick = onClick, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0XFF227172)
                    ),
                    modifier = Modifier.fillMaxWidth(0.7f)
                ) {
                    Spacer(modifier = Modifier.padding(end = 25.dp))
                    Text(text = "Add Quantity")
                    Spacer(modifier = Modifier.padding(end = 30.dp))
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
                }
            }
        }
    }
}

@Preview
@Composable
fun QuantityPreview() {
    QuantityScreen(onClick = { /*TODO*/ }, value = "", onValueChange = {})
}
