package ru.alexeypanchenko.mobuisdonor.list.dependencies

import ru.alexeypanchenko.mobuisdonor.list.ListItem

interface ListOutRoute {
    fun openDetail(item: ListItem)
    fun openSettings()
    fun openAdd()
}