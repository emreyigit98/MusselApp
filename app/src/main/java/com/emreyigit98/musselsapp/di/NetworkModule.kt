package com.emreyigit98.musselsapp.di

import com.emreyigit98.musselsapp.data.remote.api.NetworkApi
import com.emreyigit98.musselsapp.domain.repo.NetworkApiImpl
import com.emreyigit98.musselsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofitObject() : Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Singleton
    @Provides
    fun providesNetworkApi(retrofit: Retrofit) : NetworkApi {
        return retrofit.create(NetworkApi::class.java)
    }
    @Singleton
    @Provides
    fun providesNetworkApiImpl(networkApi: NetworkApi) : NetworkApiImpl {
        return NetworkApiImpl(networkApi = networkApi)
    }
}