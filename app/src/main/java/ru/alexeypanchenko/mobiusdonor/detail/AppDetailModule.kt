package ru.alexeypanchenko.mobiusdonor.detail

import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobiusdonor.ItemsRepository
import ru.alexeypanchenko.mobiusdonor.db.ItemEntry
import ru.alexeypanchenko.mobiusdonor.detail.dependencies.DetailItemRepository

@Module
class AppDetailModule {

    @Provides
    fun getDetailRepository(itemsRepository: ItemsRepository): DetailItemRepository {
        return object : DetailItemRepository {

            override fun getDetailItem(itemId: Int): DetailItem? {
                val dbItem: ItemEntry = itemsRepository.getById(itemId) ?: return null
                return DetailItem(dbItem.id, dbItem.title, dbItem.description, dbItem.additionalText)
            }

            override fun removeDetailItem(itemId: Int) {
                itemsRepository.removeById(itemId)
            }

        }
    }

}