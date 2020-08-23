package ru.alexeypanchenko.mobuisdonor.list.dependencies

import ru.alexeypanchenko.mobuisdonor.list.ListItem

interface ItemsRepository {
    fun getItems(): List<ListItem>
}