package com.emreyigit98.musselsapp.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.emreyigit98.musselsapp.data.local.model.MusselDetail

@Dao
interface MusselAppDao {

    @Insert
    suspend fun addMusselDetail(musselDetail: MusselDetail)

    @Query("SELECT * FROM musselDetail")
    suspend fun allMusselDetail() : List<MusselDetail>



}