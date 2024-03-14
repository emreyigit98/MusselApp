package com.emreyigit98.musselsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.emreyigit98.musselsapp.presentation.navigation.NavAppScreen
import com.emreyigit98.musselsapp.presentation.screen.customer_screen.CustomerScreenViewModel
import com.emreyigit98.musselsapp.presentation.screen.customer_screen.MainCustomerScreen
import com.emreyigit98.musselsapp.presentation.ui.theme.MusselsAppTheme
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MusselsAppTheme(darkTheme = false) {
                NavAppScreen()
            }
        }
    }
}
