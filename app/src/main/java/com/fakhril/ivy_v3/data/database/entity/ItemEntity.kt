package com.fakhril.ivy_v3.data.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Item",
    foreignKeys = [
        ForeignKey(
            entity = PlaceEntity::class,
            parentColumns = ["idPlace"],
            childColumns = ["idPlace"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)

data class ItemEntity (
    @PrimaryKey(autoGenerate = true)var idItem: Int = 0,
    var itemName : String,
    var total : Int,
    var idPlace : Int
)
