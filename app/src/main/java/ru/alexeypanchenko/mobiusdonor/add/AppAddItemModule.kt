package ru.alexeypanchenko.mobiusdonor.add

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.delay
import ru.alexeypanchenko.mobiusdonor.ItemsRepository
import ru.alexeypanchenko.mobiusdonor.add.dependencies.AddItemRepository
import ru.alexeypanchenko.mobiusdonor.db.ItemEntry

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