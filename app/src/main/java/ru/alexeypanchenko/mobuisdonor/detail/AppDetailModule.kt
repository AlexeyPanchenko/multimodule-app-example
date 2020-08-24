package ru.alexeypanchenko.mobuisdonor.detail

import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.detail.dependencies.DetailItemRepository

@Module
class AppDetailModule {

    @Provides
    fun getDetailRepository(): DetailItemRepository {
        return object : DetailItemRepository {

            override fun getDetailItem(itemId: Int): DetailItem {
                return DetailItem(itemId, "FoundItem", "Found description", "Additional text")
            }

        }
    }

}