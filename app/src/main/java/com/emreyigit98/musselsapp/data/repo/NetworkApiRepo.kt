package com.emreyigit98.musselsapp.data.repo

import com.emreyigit98.musselsapp.data.remote.model.CustomersModel
import com.emreyigit98.musselsapp.data.remote.model.MusselsModel

interface NetworkApiRepo {

    suspend fun getAllCustomerNameRepo() : List<CustomersModel>

    suspend fun getAllMusselRepo() : List<MusselsModel>

}