package ru.alexeypanchenko.mobiusdonor.list.dependencies

import ru.alexeypanchenko.mobiusdonor.list.ListItem

interface ListItemsRepository {
    fun getItems(): List<ListItem>
}