package com.fakhril.ivy_v3.data.database.dao

import androidx.room.*
import com.fakhril.ivy_v3.data.database.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: ItemEntity)

    @Update
    suspend fun updateItem(item: ItemEntity)

    @Delete
    suspend fun deleteItem(item: ItemEntity)

    @Query("SELECT * FROM item ORDER BY idItem DESC")
    fun getItems(): Flow<List<ItemEntity>>

    @Query("SELECT * FROM item WHERE idItem = :id")
    fun getItem(id: Int): Flow<ItemEntity>

}