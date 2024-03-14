package com.emreyigit98.musselsapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class CustomersModel(
    @SerializedName("id")
    val customerId : Int,
    @SerializedName("customer_name")
    val customerName : String
)
