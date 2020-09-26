package ru.alexeypanchenko.mobiusdonor.list

import ru.alexeypanchenko.mobiusdonor.ItemsRepository
import ru.alexeypanchenko.mobiusdonor.list.dependencies.ListItemsRepository
import javax.inject.Inject

class AppListItemsRepository @Inject constructor(
    private val itemsRepository: ItemsRepository
) : ListItemsRepository {

    override fun getItems(): List<ListItem> {
        return itemsRepository.getAll().map { ListItem(it.id, it.title, it.description) }
    }

}