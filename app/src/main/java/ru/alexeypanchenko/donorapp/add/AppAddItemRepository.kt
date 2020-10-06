package ru.alexeypanchenko.donorapp.add

import kotlinx.coroutines.delay
import ru.alexeypanchenko.donorapp.ItemsRepository
import ru.alexeypanchenko.donorapp.add.dependencies.AddItemRepository
import ru.alexeypanchenko.donorapp.db.ItemEntry
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