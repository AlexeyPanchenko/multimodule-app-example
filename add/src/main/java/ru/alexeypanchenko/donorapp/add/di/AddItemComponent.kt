package ru.alexeypanchenko.donorapp.add.di

import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.donorapp.add.AddInRoute
import ru.alexeypanchenko.donorapp.add.dependencies.AddItemRepository
import javax.inject.Singleton

@Singleton
@Component(dependencies = [AddItemDependencies::class], modules = [AddItemModule::class])
interface AddItemComponent {
    fun getAddInRoute(): AddInRoute
    fun getAddItemRepository(): AddItemRepository
}

interface AddItemDependencies {
    fun getAddItemRepository(): AddItemRepository
}

@Module
class AddItemModule {

    @Provides
    @Singleton
    fun getAddInRoute(): AddInRoute = AddInRoute()
}