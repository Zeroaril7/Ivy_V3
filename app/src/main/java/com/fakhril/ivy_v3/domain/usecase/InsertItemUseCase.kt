package com.fakhril.ivy_v3.domain.usecase

import com.fakhril.ivy_v3.domain.model.Item
import com.fakhril.ivy_v3.domain.repository.IItemRepository

class InsertItemUseCase (private val itemRepository: IItemRepository){
    suspend operator fun invoke(
        itemName: String, total: Int, idPlace: Int
    ) = itemRepository.insertItem(Item(itemName = itemName, total = total, idPlace = idPlace))
}