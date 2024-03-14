package com.emreyigit98.musselsapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emreyigit98.musselsapp.R
import com.emreyigit98.musselsapp.presentation.navigation.Screen

@Composable
fun SpecialTopAppBar(
    topBarName: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.padding(all = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(
                0XFF227172
            )
        ),
        elevation = CardDefaults.cardElevation(
            5.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onClick
            ) {
                Image(
                    painter = painterResource(id = R.drawable.menu_icon),
                    contentDescription = "menu_icon",
                )
            }
            Spacer(modifier = Modifier.padding(start = 10.dp))
            Text(
                text = topBarName,
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


