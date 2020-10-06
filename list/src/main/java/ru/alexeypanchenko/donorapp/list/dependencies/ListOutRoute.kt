package ru.alexeypanchenko.donorapp.list.dependencies

import ru.alexeypanchenko.donorapp.list.ListItem

interface ListOutRoute {
    fun openDetail(item: ListItem)
    fun openSettings()
    fun openAdd()
}