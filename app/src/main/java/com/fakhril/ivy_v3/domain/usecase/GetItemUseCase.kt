package com.fakhril.ivy_v3.domain.usecase

import com.fakhril.ivy_v3.domain.model.Item
import com.fakhril.ivy_v3.domain.repository.IItemRepository
import kotlinx.coroutines.flow.Flow

class GetItemUseCase(val itemRepository: IItemRepository) {
    operator fun invoke()  : Flow<List<Item?>> = itemRepository.getItems()
}