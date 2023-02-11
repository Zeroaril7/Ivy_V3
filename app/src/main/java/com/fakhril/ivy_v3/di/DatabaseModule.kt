package com.fakhril.ivy_v3.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fakhril.ivy_v3.data.database.IvyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideIvyDatabase(application: Application) =
        Room.databaseBuilder(application, IvyDatabase::class.java, "IvyDatabase.db")
            .build()

    @Provides
    fun providePlaceDao(ivyDatabase: IvyDatabase) = ivyDatabase.getPlaceDao()

    @Provides
    fun provideItemDao(ivyDatabase: IvyDatabase) = ivyDatabase.getItemDao()
}