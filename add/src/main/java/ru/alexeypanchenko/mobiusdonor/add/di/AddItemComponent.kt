package ru.alexeypanchenko.mobiusdonor.add.di

import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobiusdonor.add.AddFragment
import ru.alexeypanchenko.mobiusdonor.add.AddInRoute
import ru.alexeypanchenko.mobiusdonor.add.dependencies.AddItemRepository

@Component(dependencies = [AddItemDependencies::class], modules = [AddItemModule::class])
interface AddItemComponent {
    fun getAddInRoute(): AddInRoute
    fun inject(fragment: AddFragment)
}

interface AddItemDependencies {
    fun getAddItemRepository(): AddItemRepository
}

@Module
class AddItemModule {

    @Provides
    fun getAddInRoute(): AddInRoute = AddInRoute()
}