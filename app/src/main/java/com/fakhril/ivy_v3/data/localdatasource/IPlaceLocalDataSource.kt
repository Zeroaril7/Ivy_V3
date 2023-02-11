package com.fakhril.ivy_v3.data.localdatasource

import com.fakhril.ivy_v3.domain.model.Place
import kotlinx.coroutines.flow.Flow

interface IPlaceLocalDataSource {
    fun getPlaces(): Flow<List<Place?>>

    fun getPlace(id: Int): Flow<Place?>

    suspend fun deletePlace(place: Place)

    suspend fun updatePlace(place: Place)

    suspend fun  insertPlace(place: Place)

}