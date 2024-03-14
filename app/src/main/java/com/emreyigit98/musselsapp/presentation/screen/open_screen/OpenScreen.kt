package com.emreyigit98.musselsapp.presentation.screen.open_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.emreyigit98.musselsapp.R

@Composable
fun OpenScreen(
    nextScreen : () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.add_record_icon),
            contentDescription = "add_record_icon"
        )
        Spacer(
            modifier = Modifier.padding(top = 50.dp)
        )
        Button(
            onClick =  nextScreen, colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF227172)
            ),
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text(text = "Add Record")
        }
    }
}
