package com.fakhril.ivy_v3.di

import com.fakhril.ivy_v3.data.repository.PlaceRepository
import com.fakhril.ivy_v3.domain.repository.IItemRepository
import com.fakhril.ivy_v3.domain.repository.IPlaceRepository
import com.fakhril.ivy_v3.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetPlacesUseCase(
        placeRepository: IPlaceRepository
    ) = GetPlacesUseCase(placeRepository)

    @Provides
    @ViewModelScoped
    fun proveideInsertPlaceUseCase(
        placeRepository: IPlaceRepository
    ) = InsertPlaceUseCase(placeRepository)

    @Provides
    @ViewModelScoped
    fun provideUpdatePlaceUseCase(
        placeRepository: IPlaceRepository
    ) = UpdatePlaceUseCase(placeRepository)

    @Provides
    @ViewModelScoped
    fun provideDeletePlaceUseCase(
        placeRepository: IPlaceRepository
    ) = DeletePlaceUseCase(placeRepository)

    @Provides
    @ViewModelScoped
    fun provideGetItemUseCase(
        itemRepository: IItemRepository
    ) = GetItemUseCase(itemRepository)

    @Provides
    @ViewModelScoped
    fun proveideInsertItemUseCase(
        itemRepository: IItemRepository
    ) = InsertItemUseCase(itemRepository)

    @Provides
    @ViewModelScoped
    fun provideUpdateItemUseCase(
        itemRepository: IItemRepository
    ) = UpdateItemUseCase(itemRepository)

    @Provides
    @ViewModelScoped
    fun provideDeleteItemUseCase(
        itemRepository: IItemRepository
    ) = DeleteItemUseCase(itemRepository)
}

