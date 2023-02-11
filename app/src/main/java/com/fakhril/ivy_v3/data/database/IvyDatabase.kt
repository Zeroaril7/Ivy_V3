package com.fakhril.ivy_v3.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fakhril.ivy_v3.data.database.dao.ItemDao
import com.fakhril.ivy_v3.data.database.dao.PlaceDao
import com.fakhril.ivy_v3.data.database.entity.ItemEntity
import com.fakhril.ivy_v3.data.database.entity.PlaceEntity

@Database(entities = [PlaceEntity::class, ItemEntity::class],
    version = 1,
    exportSchema = false
)


abstract class IvyDatabase: RoomDatabase() {
    abstract fun getPlaceDao() : PlaceDao
    abstract fun getItemDao() : ItemDao
}
