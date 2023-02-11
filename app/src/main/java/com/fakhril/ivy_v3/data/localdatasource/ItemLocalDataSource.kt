package com.fakhril.ivy_v3.data.localdatasource

import com.fakhril.ivy_v3.data.database.dao.ItemDao
import com.fakhril.ivy_v3.data.database.mapper.ItemMapper.toDomain
import com.fakhril.ivy_v3.data.database.mapper.ItemMapper.toEntity
import com.fakhril.ivy_v3.data.database.mapper.PlaceMapper.toDomain
import com.fakhril.ivy_v3.domain.model.Item
import com.fakhril.ivy_v3.domain.model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ItemLocalDataSource(private val itemDao: ItemDao): IItemLocalDataSource {
    override fun getItems(): Flow<List<Item?>> = itemDao.getItems().map{ list ->
        list.map { it.toDomain() }
    }

    override fun getItem(id: Int): Flow<Item?> = itemDao.getItem(id).map{
        it.toDomain()
    }

    override suspend fun deleteItem(item: Item) {
        item.toEntity()?.let { itemDao.deleteItem(it) }
    }

    override suspend fun updateItem(item: Item) {
        item.toEntity()?.let { itemDao.updateItem(it) }
    }

    override suspend fun insertItem(item: Item) {
        item.toEntity()?.let { itemDao.insertItem(it) }
    }
}