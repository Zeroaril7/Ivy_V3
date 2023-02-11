package com.fakhril.ivy_v3.domain.usecase

import com.fakhril.ivy_v3.data.repository.PlaceRepository
import com.fakhril.ivy_v3.domain.model.Place
import com.fakhril.ivy_v3.domain.repository.IPlaceRepository
import kotlinx.coroutines.flow.Flow

class GetPlacesUseCase(val placeRepository: IPlaceRepository) {
    operator fun invoke(): Flow<List<Place?>> = placeRepository.getPlaces()
}