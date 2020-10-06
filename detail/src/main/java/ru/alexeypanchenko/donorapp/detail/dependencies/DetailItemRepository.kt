package ru.alexeypanchenko.donorapp.detail.dependencies

import androidx.annotation.WorkerThread
import ru.alexeypanchenko.donorapp.detail.DetailItem

interface DetailItemRepository {
    @WorkerThread
    fun getDetailItem(itemId: Int): DetailItem?
    fun removeDetailItem(itemId: Int)
}