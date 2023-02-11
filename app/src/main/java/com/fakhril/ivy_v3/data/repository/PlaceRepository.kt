package com.fakhril.ivy_v3.data.repository


import com.fakhril.ivy_v3.data.localdatasource.IPlaceLocalDataSource
import com.fakhril.ivy_v3.domain.model.Place
import com.fakhril.ivy_v3.domain.repository.IPlaceRepository
import kotlinx.coroutines.flow.Flow

class PlaceRepository(private val placeLocalDataSource: IPlaceLocalDataSource) : IPlaceRepository {

    override fun getPlaces(): Flow<List<Place?>> = placeLocalDataSource.getPlaces()


    override fun getPlace(id: Int): Flow<Place?> = placeLocalDataSource.getPlace(id)


    override suspend fun deletePlace(place: Place) {
        placeLocalDataSource.deletePlace(place)
    }

    override suspend fun updatePlace(place: Place) {
        placeLocalDataSource.updatePlace(place)
    }

    override suspend fun insertPlace(place: Place) {
        placeLocalDataSource.insertPlace(place)
    }
}