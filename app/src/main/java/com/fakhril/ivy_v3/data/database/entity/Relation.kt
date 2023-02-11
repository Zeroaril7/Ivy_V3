package com.fakhril.ivy_v3.data.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class Relation (
    @Embedded val place: PlaceEntity,
    @Relation(
        parentColumn = "idPlace",
        entityColumn = "idPlace",
        entity = ItemEntity::class
    )
    val item: List<ItemEntity>
    )