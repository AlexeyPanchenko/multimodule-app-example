package ru.alexeypanchenko.mobiusdonor.detail.dependencies

import androidx.annotation.WorkerThread
import ru.alexeypanchenko.mobiusdonor.detail.DetailItem

interface DetailItemRepository {
    @WorkerThread
    fun getDetailItem(itemId: Int): DetailItem?
    fun removeDetailItem(itemId: Int)
}