package ru.alexeypanchenko.mobiusdonor.list.dependencies

import ru.alexeypanchenko.mobiusdonor.list.ListItem

interface ListOutRoute {
    fun openDetail(item: ListItem)
    fun openSettings()
    fun openAdd()
}