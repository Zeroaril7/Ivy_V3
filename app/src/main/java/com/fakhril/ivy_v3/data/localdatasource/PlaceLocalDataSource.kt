package com.fakhril.ivy_v3.data.localdatasource

import com.fakhril.ivy_v3.data.database.dao.PlaceDao
import com.fakhril.ivy_v3.data.database.mapper.PlaceMapper.toDomain
import com.fakhril.ivy_v3.data.database.mapper.PlaceMapper.toEntity
import com.fakhril.ivy_v3.domain.model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlaceLocalDataSource(private val placeDao: PlaceDao): IPlaceLocalDataSource {
    override fun getPlaces(): Flow<List<Place?>> = placeDao.getPlaces().map{ list ->
        list.map { it.toDomain() }
    }

    override fun getPlace(id: Int): Flow<Place?> = placeDao.getPlace(id).map{
        it.toDomain()
    }

    override suspend fun deletePlace(place: Place) {
        place.toEntity()?.let {
            placeDao.deletePlace(it)
        }
    }

    override suspend fun updatePlace(place: Place) {
        place.toEntity()?.let {
            placeDao.updatePlace(it)
        }
    }

    override suspend fun insertPlace(place: Place) {
        place.toEntity()?.let {
            placeDao.insertPlace(it)
        }
    }
}