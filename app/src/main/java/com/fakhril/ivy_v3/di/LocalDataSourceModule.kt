package com.fakhril.ivy_v3.di

import com.fakhril.ivy_v3.data.database.dao.ItemDao
import com.fakhril.ivy_v3.data.database.dao.PlaceDao
import com.fakhril.ivy_v3.data.localdatasource.IItemLocalDataSource
import com.fakhril.ivy_v3.data.localdatasource.IPlaceLocalDataSource
import com.fakhril.ivy_v3.data.localdatasource.ItemLocalDataSource
import com.fakhril.ivy_v3.data.localdatasource.PlaceLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Provides
    @Singleton
    fun providePlaceLocalDataSource(placeDao: PlaceDao): IPlaceLocalDataSource =
        PlaceLocalDataSource(placeDao)

    @Provides
    @Singleton
    fun provideItemLocalDataSource(itemDao: ItemDao): IItemLocalDataSource =
        ItemLocalDataSource(itemDao)
}