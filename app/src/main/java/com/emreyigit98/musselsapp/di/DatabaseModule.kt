package com.emreyigit98.musselsapp.di

import android.content.Context
import androidx.room.Room
import com.emreyigit98.musselsapp.data.local.room.MusselAppDao
import com.emreyigit98.musselsapp.data.local.room.MusselAppDatabase
import com.emreyigit98.musselsapp.domain.repo.MusselAppDatabaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideMusselDatabase(@ApplicationContext context: Context): MusselAppDatabase {
        return Room.databaseBuilder(context, MusselAppDatabase::class.java, "mussel.db").build()
    }

    @Provides
    @Singleton
    fun provideMusselAppDao(musselAppDatabase: MusselAppDatabase): MusselAppDao {
        return musselAppDatabase.musselAppDao()
    }

    @Provides
    @Singleton
    fun provideMusselAppDatabaseImpl(musselAppDao: MusselAppDao): MusselAppDatabaseImpl {
        return MusselAppDatabaseImpl(musselAppDao)
    }
}