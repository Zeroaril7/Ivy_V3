package com.fakhril.ivy_v3.domain.model

data class Place(
    val idPlace: Int = 0,
    val placeName: String,
    val itemData: List<Item?> = ArrayList()
)
