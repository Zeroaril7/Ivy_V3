package com.fakhril.ivy_v3.data.database.entity

import androidx.room.*

@Entity(tableName = "Place", indices = [Index(value = ["placeName"], unique = true)])
data class PlaceEntity(
        @PrimaryKey(autoGenerate = true)var idPlace: Int = 0,
        var placeName : String
)