package com.emreyigit98.musselsapp.domain.repo

import com.emreyigit98.musselsapp.data.local.model.MusselDetail
import com.emreyigit98.musselsapp.data.local.room.MusselAppDao
import com.emreyigit98.musselsapp.data.repo.MusselAppDaoRepo
import javax.inject.Inject


class MusselAppDatabaseImpl @Inject constructor(
    private val musselAppDao: MusselAppDao
) : MusselAppDaoRepo {

    override suspend fun addMusselDetailRepo(musselDetail: MusselDetail) {
        musselAppDao.addMusselDetail(musselDetail)
    }

    override suspend fun allMusselDetailRepo(): List<MusselDetail> {
        return musselAppDao.allMusselDetail()
    }

}
