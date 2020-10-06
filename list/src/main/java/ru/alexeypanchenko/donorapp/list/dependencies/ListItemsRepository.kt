package ru.alexeypanchenko.donorapp.list.dependencies

import ru.alexeypanchenko.donorapp.list.ListItem

interface ListItemsRepository {
    fun getItems(): List<ListItem>
}