package ru.alexeypanchenko.donorapp.add

import dagger.Binds
import dagger.Module
import ru.alexeypanchenko.donorapp.add.dependencies.AddItemRepository
import javax.inject.Singleton

@Module
abstract class AppAddItemModule {

    @Singleton
    @Binds
    abstract fun getAddItemRepository(repository: AppAddItemRepository): AddItemRepository
}