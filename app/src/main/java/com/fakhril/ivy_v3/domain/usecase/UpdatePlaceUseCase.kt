package com.fakhril.ivy_v3.domain.usecase

import com.fakhril.ivy_v3.data.repository.PlaceRepository
import com.fakhril.ivy_v3.domain.model.Place
import com.fakhril.ivy_v3.domain.repository.IPlaceRepository

class UpdatePlaceUseCase(private val placeRepository: IPlaceRepository) {
    suspend operator fun invoke(place: Place){
        placeRepository.updatePlace(place)
    }
}