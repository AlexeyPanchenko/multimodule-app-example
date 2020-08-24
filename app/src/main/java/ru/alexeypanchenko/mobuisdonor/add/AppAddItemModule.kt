package ru.alexeypanchenko.mobuisdonor.add

import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.add.dependencies.AddItemRepository

@Module
class AppAddItemModule {

    @Provides
    fun getAddItemRepository(): AddItemRepository {
        return object : AddItemRepository {
            override suspend fun addItem(item: AddItem) {
            }
        }
    }
}