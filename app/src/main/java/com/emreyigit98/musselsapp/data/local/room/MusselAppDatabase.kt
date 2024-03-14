package com.emreyigit98.musselsapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emreyigit98.musselsapp.data.local.model.MusselDetail

@Database(entities = [MusselDetail::class], version = 1, exportSchema = true)
abstract class MusselAppDatabase : RoomDatabase() {
    abstract fun musselAppDao() : MusselAppDao
}