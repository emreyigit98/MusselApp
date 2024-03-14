package com.emreyigit98.musselsapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class MusselsModel(
    @SerializedName("name")
    val musselName : String,
    @SerializedName("price")
    val musselPrice : Double,
    @SerializedName("image_url")
    val musselImage : String
)
