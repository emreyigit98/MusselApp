package com.emreyigit98.musselsapp.presentation.screen.mussel_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.emreyigit98.musselsapp.data.remote.model.MusselsModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun MusselScreen(
    musselScreenViewModel: MusselScreenViewModel,
    onSelectItem: (price: Double, name: String) -> Unit,
    musselItemList: List<MusselsModel>,
    onNextScreen : () -> Unit
) {
    var selectedItem by remember { mutableStateOf("") }

    val swipeState = musselScreenViewModel.refreshState.collectAsState()
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = swipeState.value),
        onRefresh = {
            musselScreenViewModel.refresh()
           // musselScreenViewModel.allMussels()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(musselItemList) { musselModel ->
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
                            .selectable(selectedItem == musselModel.musselName) {
                                onSelectItem(musselModel.musselPrice, musselModel.musselName)
                                selectedItem = musselModel.musselName
                                onNextScreen()
                            },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(0.6f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedItem == musselModel.musselName,
                                onClick = {
                                    onSelectItem(musselModel.musselPrice, musselModel.musselName)
                                    selectedItem = musselModel.musselName
                                }
                            )
                            Spacer(modifier = Modifier.padding(start = 20.dp))
                            Text(
                                text = musselModel.musselName,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                        SubcomposeAsyncImage(
                            model = musselModel.musselImage,
                            contentDescription = "image",
                            modifier = Modifier
                                .size(50.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.Crop
                        ) {
                            when (painter.state) {
                                is AsyncImagePainter.State.Error -> Text(text = "Error")
                                is AsyncImagePainter.State.Loading -> CircularProgressIndicator(color = Color(0XFF227172))
                                else -> SubcomposeAsyncImageContent()
                            }
                        }
                    }
                }
            }
        }
    }
}
