package com.emreyigit98.musselsapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "musselDetail")
data class MusselDetail(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val customerName : String,
    val musselName : String,
    val musselPrice : Double,
    val musselQuantity : Int,
    val musselResultPrice : Double,
    val date : String
)
