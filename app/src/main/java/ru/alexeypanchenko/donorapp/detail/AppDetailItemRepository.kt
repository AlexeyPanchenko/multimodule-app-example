package ru.alexeypanchenko.donorapp.detail

import androidx.annotation.WorkerThread
import ru.alexeypanchenko.donorapp.ItemsRepository
import ru.alexeypanchenko.donorapp.db.ItemEntry
import ru.alexeypanchenko.donorapp.detail.dependencies.DetailItemRepository
import javax.inject.Inject

class AppDetailItemRepository @Inject constructor(
    private val itemsRepository: ItemsRepository
) : DetailItemRepository {

    @WorkerThread
    override fun getDetailItem(itemId: Int): DetailItem? {
        val dbItem: ItemEntry = itemsRepository.getById(itemId) ?: return null
        return DetailItem(dbItem.id, dbItem.title, dbItem.description, dbItem.additionalText)
    }

    override fun removeDetailItem(itemId: Int) {
        itemsRepository.removeById(itemId)
    }
}