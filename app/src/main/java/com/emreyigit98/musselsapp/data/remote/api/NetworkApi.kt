package com.emreyigit98.musselsapp.data.remote.api

import com.emreyigit98.musselsapp.data.remote.model.CustomersModel
import com.emreyigit98.musselsapp.data.remote.model.MusselsModel
import retrofit2.http.GET

interface NetworkApi {

    @GET("emreyigit98/MusselAppJson/master/Customer.json")
    suspend fun getAllCustomerName() : List<CustomersModel>

    @GET("emreyigit98/MusselAppJson/master/Mussels.json")
    suspend fun getAllMussel() : List<MusselsModel>

}