package com.emreyigit98.musselsapp.data.repo

import com.emreyigit98.musselsapp.data.local.model.MusselDetail

interface MusselAppDaoRepo {

    suspend fun addMusselDetailRepo(musselDetail: MusselDetail)

    suspend fun allMusselDetailRepo() : List<MusselDetail>



}