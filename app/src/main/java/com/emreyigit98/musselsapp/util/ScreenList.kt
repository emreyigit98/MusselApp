package com.emreyigit98.musselsapp.util

import com.emreyigit98.musselsapp.R
import com.emreyigit98.musselsapp.presentation.navigation.Screen

object ScreenList {
    val screenList : List<Pair<Int , Screen>> = mutableListOf(
        Pair(R.drawable.add_record_icon,Screen.OPEN_SCREEN),
        Pair(R.drawable.database_icon,Screen.QUERY_SCREEN)
    )
}