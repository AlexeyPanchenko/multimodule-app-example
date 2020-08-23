package ru.alexeypanchenko.mobuisdonor.list

import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ItemsRepository
import javax.inject.Singleton

@Module
class AppListModule {

    @Provides
    @Singleton
    fun provideItemsRepository(): ItemsRepository {
        return object : ItemsRepository {
            override fun getItems(): List<ListItem> {
                return listOf(
                    ListItem(1, "Title Title Title TitleTitleTitleTitleTitleTitlev  Title", "Description"),
                    ListItem(2, "Title2", "Description2")
                )
            }
        }
    }


}