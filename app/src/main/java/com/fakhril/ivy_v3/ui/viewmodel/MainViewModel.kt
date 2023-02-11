package com.fakhril.ivy_v3.ui.viewmodel

import androidx.lifecycle.*
import com.fakhril.ivy_v3.domain.model.Item
import com.fakhril.ivy_v3.domain.model.Place
import com.fakhril.ivy_v3.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getPlaces: GetPlacesUseCase,
    private val insertPlace: InsertPlaceUseCase,
    private val updatePlace: UpdatePlaceUseCase,
    private val deletePlace: DeletePlaceUseCase,
    getItems: GetItemUseCase,
    private val insertItem: InsertItemUseCase,
    private val updateItem: UpdateItemUseCase,
    private val deleteItem: DeleteItemUseCase
): ViewModel(){
    val getplaces: LiveData<List<Place?>> = getPlaces().asLiveData()

    fun insertPlace(placeName: String) = liveData {
        emit(insertPlace.invoke(placeName))
    }

    fun deletePlace(place: Place) = viewModelScope.launch {
        deletePlace.invoke(place)
    }

    fun updatePlace(place: Place) = viewModelScope.launch {
        updatePlace.invoke(place)
    }

    val getItems: LiveData<List<Item?>> = getItems().asLiveData()

    fun insertItem(itemName: String, total: Int, idPlace: Int) = liveData {
        emit(insertItem.invoke(itemName, total, idPlace))
    }

    fun deleteItem(item: Item) = viewModelScope.launch {
        deleteItem.invoke(item)
    }

    fun updateItem(item: Item) = viewModelScope.launch {
        updateItem.invoke(item)
    }
}