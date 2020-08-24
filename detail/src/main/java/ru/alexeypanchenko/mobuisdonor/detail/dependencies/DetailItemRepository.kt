package ru.alexeypanchenko.mobuisdonor.detail.dependencies

import androidx.annotation.WorkerThread
import ru.alexeypanchenko.mobuisdonor.detail.DetailItem

interface DetailItemRepository {
    @WorkerThread
    fun getDetailItem(itemId: Int): DetailItem
}