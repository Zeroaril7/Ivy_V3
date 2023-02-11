package com.fakhril.ivy_v3.data.database.mapper

import com.fakhril.ivy_v3.data.database.entity.PlaceEntity
import com.fakhril.ivy_v3.data.database.entity.Relation
import com.fakhril.ivy_v3.data.database.mapper.ItemMapper.toDomain
import com.fakhril.ivy_v3.domain.model.Place

object PlaceMapper {
    fun PlaceEntity?.toDomain(): Place? = this?.let {
        Place(
            idPlace = it.idPlace,
            placeName = it.placeName
        )
    }

    fun Relation?.toDomain(): Place? = this?.let {
        Place(
            idPlace = it.place.idPlace,
            placeName = it.place.placeName,
            itemData = it.item.map { item -> item.toDomain() }
        )
    }

    fun Place?.toEntity() : PlaceEntity? = this?.let {
        PlaceEntity(
            idPlace = it.idPlace,
            placeName = it.placeName
        )
    }
}