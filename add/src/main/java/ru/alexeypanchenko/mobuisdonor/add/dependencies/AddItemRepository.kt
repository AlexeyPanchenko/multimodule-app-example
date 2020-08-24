package ru.alexeypanchenko.mobuisdonor.add.dependencies

import androidx.annotation.WorkerThread
import ru.alexeypanchenko.mobuisdonor.add.AddItem

interface AddItemRepository {
    @WorkerThread
    suspend fun addItem(item: AddItem)
}