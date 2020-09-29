package ru.alexeypanchenko.mobiusdonor.add.di

import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobiusdonor.add.AddInRoute
import ru.alexeypanchenko.mobiusdonor.add.dependencies.AddItemRepository
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