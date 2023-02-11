package com.fakhril.ivy_v3.domain.usecase


import com.fakhril.ivy_v3.domain.model.Place
import com.fakhril.ivy_v3.domain.repository.IPlaceRepository

class DeletePlaceUseCase(private val placeRepository: IPlaceRepository) {
    suspend operator fun invoke(place: Place) {
        placeRepository.deletePlace(place)
    }
}