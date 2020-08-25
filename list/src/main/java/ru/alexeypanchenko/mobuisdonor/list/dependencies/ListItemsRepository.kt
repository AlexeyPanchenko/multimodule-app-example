package ru.alexeypanchenko.mobuisdonor.list.dependencies

import ru.alexeypanchenko.mobuisdonor.list.ListItem

interface ListItemsRepository {
    fun getItems(): List<ListItem>
}