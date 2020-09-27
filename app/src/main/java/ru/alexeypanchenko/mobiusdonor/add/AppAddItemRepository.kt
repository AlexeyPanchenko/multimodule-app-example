package ru.alexeypanchenko.mobiusdonor.add

import kotlinx.coroutines.delay
import ru.alexeypanchenko.mobiusdonor.ItemsRepository
import ru.alexeypanchenko.mobiusdonor.add.dependencies.AddItemRepository
import ru.alexeypanchenko.mobiusdonor.db.ItemEntry
import javax.inject.Inject

class AppAddItemRepository @Inject constructor(
    private val itemsRepository: ItemsRepository
) : AddItemRepository {

    override suspend fun addItem(item: AddItem) {
        delay(1000)
        itemsRepository.addItem(
            ItemEntry(
                title = item.title,
                description = item.description,
                additionalText = item.additionalText
            )
        )
    }

}