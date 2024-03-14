package com.emreyigit98.musselsapp.domain.repo

import com.emreyigit98.musselsapp.data.remote.api.NetworkApi
import com.emreyigit98.musselsapp.data.remote.model.CustomersModel
import com.emreyigit98.musselsapp.data.remote.model.MusselsModel
import com.emreyigit98.musselsapp.data.repo.NetworkApiRepo
import javax.inject.Inject

class NetworkApiImpl @Inject constructor(
    private val networkApi: NetworkApi
) : NetworkApiRepo {

    override suspend fun getAllCustomerNameRepo(): List<CustomersModel> {
        return networkApi.getAllCustomerName()
    }

    override suspend fun getAllMusselRepo(): List<MusselsModel> {
        return networkApi.getAllMussel()
    }
}