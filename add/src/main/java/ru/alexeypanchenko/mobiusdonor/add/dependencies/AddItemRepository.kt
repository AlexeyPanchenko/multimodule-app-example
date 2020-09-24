package ru.alexeypanchenko.mobiusdonor.add.dependencies

import androidx.annotation.WorkerThread
import ru.alexeypanchenko.mobiusdonor.add.AddItem

interface AddItemRepository {
    @WorkerThread
    suspend fun addItem(item: AddItem)
}