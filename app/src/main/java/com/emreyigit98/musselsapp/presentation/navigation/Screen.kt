package com.emreyigit98.musselsapp.presentation.navigation


import androidx.annotation.StringRes
import com.emreyigit98.musselsapp.R

enum class Screen(
    @StringRes val screenRoute : Int,
    val screenName : String
) {
    OPEN_SCREEN(screenRoute = R.string.open_screen,"Record"),
    CUSTOMER_SCREEN(screenRoute = R.string.customer_screen,"Customer"),
    MUSSEL_SCREEN(screenRoute = R.string.mussel_screen,"Mussel"),
    QUANTITY_SCREEN(R.string.quantity_screen,"Quantity"),
    RESULT_SCREEN(R.string.result_screen,"Result"),
    QUERY_SCREEN(R.string.query_screen,"Query"),
    ORDER_SCREEN(R.string.order_screen,"detailArg")
}