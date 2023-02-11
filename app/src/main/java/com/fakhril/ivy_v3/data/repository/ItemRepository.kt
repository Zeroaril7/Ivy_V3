package com.fakhril.ivy_v3.data.repository

import com.fakhril.ivy_v3.data.localdatasource.IItemLocalDataSource
import com.fakhril.ivy_v3.domain.model.Item
import com.fakhril.ivy_v3.domain.repository.IItemRepository
import kotlinx.coroutines.flow.Flow

class ItemRepository(private val itemLocalDataSource: IItemLocalDataSource): IItemRepository {
    override fun getItems(): Flow<List<Item?>> = itemLocalDataSource.getItems()

    override fun getItem(id: Int): Flow<Item?> = itemLocalDataSource.getItem(id)

    override suspend fun deleteItem(item: Item) {
        itemLocalDataSource.deleteItem(item)
    }

    override suspend fun updateItem(item: Item) {
        itemLocalDataSource.updateItem(item)
    }

    override suspend fun insertItem(item: Item) {
        itemLocalDataSource.insertItem(item)
    }
}