package ru.alexeypanchenko.donorapp.add.dependencies

import androidx.annotation.WorkerThread
import ru.alexeypanchenko.donorapp.add.AddItem

interface AddItemRepository {
    @WorkerThread
    suspend fun addItem(item: AddItem)
}