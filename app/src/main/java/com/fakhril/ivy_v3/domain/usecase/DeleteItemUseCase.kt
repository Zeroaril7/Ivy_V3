package com.fakhril.ivy_v3.domain.usecase

import com.fakhril.ivy_v3.domain.model.Item
import com.fakhril.ivy_v3.domain.repository.IItemRepository

class DeleteItemUseCase(private val itemRepository: IItemRepository) {
    suspend operator fun invoke(item: Item){
        itemRepository.deleteItem(item)
    }
}