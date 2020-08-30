package ru.alexeypanchenko.mobuisdonor.list

import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.ItemsRepository
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListItemsRepository
import javax.inject.Singleton

@Module
class AppListModule {

    @Provides
    @Singleton
    fun provideListItemsRepository(itemsRepository: ItemsRepository): ListItemsRepository {
        return object : ListItemsRepository {
            override fun getItems(): List<ListItem> {
                return itemsRepository.getAll().map { ListItem(it.id, it.title, it.description) }
            }
        }
    }

}