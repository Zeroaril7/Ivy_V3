package com.fakhril.ivy_v3.data.database.dao

import androidx.room.*
import com.fakhril.ivy_v3.data.database.entity.PlaceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlace(place: PlaceEntity)

    @Update
    suspend fun updatePlace(place: PlaceEntity)

    @Delete
    suspend fun deletePlace(place: PlaceEntity)

    @Transaction
    @Query("SELECT * FROM place")
    fun getPlaces(): Flow<List<PlaceEntity>>

    @Query("SELECT * FROM place WHERE idPlace = :id")
    fun getPlace(id: Int): Flow<PlaceEntity>

}