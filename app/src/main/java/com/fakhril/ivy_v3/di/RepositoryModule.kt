package com.fakhril.ivy_v3.di

import com.fakhril.ivy_v3.data.localdatasource.IItemLocalDataSource
import com.fakhril.ivy_v3.data.localdatasource.IPlaceLocalDataSource
import com.fakhril.ivy_v3.data.repository.ItemRepository
import com.fakhril.ivy_v3.data.repository.PlaceRepository
import com.fakhril.ivy_v3.domain.repository.IItemRepository
import com.fakhril.ivy_v3.domain.repository.IPlaceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePlaceRepository(placeLocalDataSource: IPlaceLocalDataSource) : IPlaceRepository =
        PlaceRepository(placeLocalDataSource)

    @Provides
    @Singleton
    fun provideItemRepository(itemLocalDataSource: IItemLocalDataSource) : IItemRepository =
        ItemRepository(itemLocalDataSource)

}