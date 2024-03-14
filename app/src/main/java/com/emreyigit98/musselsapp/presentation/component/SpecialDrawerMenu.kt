package com.emreyigit98.musselsapp.presentation.component


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emreyigit98.musselsapp.R
import com.emreyigit98.musselsapp.presentation.navigation.Screen

@Composable
fun SpecialDrawerMenu(
    screenList: List<Pair<Int, Screen>>,
    nextScreen: (Screen) -> Unit,
    click: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.7f)
            .background(color = Color.LightGray)
            .border(1.dp, color = Color(0XFF227172))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            contentAlignment = Alignment.Center
        ) {
            Icon(painter = painterResource(id = R.drawable.splash_logo), contentDescription = "icon",
                modifier = Modifier.size(100.dp),
                tint = Color(0XFF227172)
            )
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(screenList) { pairList ->
                Row(
                    modifier = Modifier.background(color = Color.White),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 10.dp)
                            .clickable {
                                nextScreen(pairList.second)
                                click()
                            },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Icon(
                            painter = painterResource(id = pairList.first),
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            tint = Color(0XFF227172)
                        )
                        Text(text = pairList.second.screenName)
                    }
                }
                Divider()
            }
        }
    }
}
