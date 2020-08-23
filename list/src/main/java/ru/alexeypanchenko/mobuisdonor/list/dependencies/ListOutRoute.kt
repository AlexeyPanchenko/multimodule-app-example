package ru.alexeypanchenko.mobuisdonor.list.dependencies

import androidx.fragment.app.Fragment
import ru.alexeypanchenko.mobuisdonor.list.ListItem

interface ListOutRoute {
    fun openDetail(fragment: Fragment, item: ListItem)
    fun openSettings(fragment: Fragment)
}