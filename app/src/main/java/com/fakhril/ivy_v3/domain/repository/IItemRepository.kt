package com.fakhril.ivy_v3.domain.repository

import com.fakhril.ivy_v3.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface IItemRepository {
    fun getItems() : Flow<List<Item?>>

    fun getItem(id: Int) : Flow<Item?>

    suspend fun deleteItem(item: Item)

    suspend fun updateItem(item: Item)

    suspend fun  insertItem(item: Item)
}