package com.emreyigit98.musselsapp.presentation.screen.result_screen

data class ResultScreenState(
    var customerName : String = "",
    var musselName : String = "",
    var musselPrice : Double = 0.0,
    var musselQuantity : Int = 0,
    var musselResultPrice : Double = 0.0,
    var date : String = ""
)
