package ru.alexeypanchenko.mobuisdonor.add

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.delay
import ru.alexeypanchenko.mobuisdonor.ItemsRepository
import ru.alexeypanchenko.mobuisdonor.add.dependencies.AddItemRepository
import ru.alexeypanchenko.mobuisdonor.db.ItemEntry

@Module
class AppAddItemModule {

    @Provides
    fun getAddItemRepository(itemsRepository: ItemsRepository): AddItemRepository {
        return object : AddItemRepository {
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
    }
}