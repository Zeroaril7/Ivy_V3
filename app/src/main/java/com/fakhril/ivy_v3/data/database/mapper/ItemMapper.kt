package com.fakhril.ivy_v3.data.database.mapper

import com.fakhril.ivy_v3.data.database.entity.ItemEntity
import com.fakhril.ivy_v3.domain.model.Item

object ItemMapper {
    fun ItemEntity?.toDomain(): Item? = this?.let {
        Item(
            idItem = it.idItem,
            itemName = it.itemName,
            total = it.total,
            idPlace = it.idPlace
        )
    }

    fun Item?.toEntity(): ItemEntity? = this?.let {
        ItemEntity(
            idItem = it.idItem,
            itemName = it.itemName,
            total = it.total,
            idPlace = it.idPlace
        )
    }
}