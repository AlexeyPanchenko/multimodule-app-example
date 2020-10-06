package ru.alexeypanchenko.donorapp.list

import dagger.Binds
import dagger.Module
import ru.alexeypanchenko.donorapp.list.dependencies.ListItemsRepository
import javax.inject.Singleton

@Module
abstract class AppListModule {

    @Singleton
    @Binds
    abstract fun provideListItemsRepository(
        itemsRepository: AppListItemsRepository
    ): ListItemsRepository

}