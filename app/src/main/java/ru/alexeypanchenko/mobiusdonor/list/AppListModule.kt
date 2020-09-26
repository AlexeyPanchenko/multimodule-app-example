package ru.alexeypanchenko.mobiusdonor.list

import dagger.Binds
import dagger.Module
import ru.alexeypanchenko.mobiusdonor.list.dependencies.ListItemsRepository
import javax.inject.Singleton

@Module
abstract class AppListModule {

    @Singleton
    @Binds
    abstract fun provideListItemsRepository(
        itemsRepository: AppListItemsRepository
    ): ListItemsRepository

}