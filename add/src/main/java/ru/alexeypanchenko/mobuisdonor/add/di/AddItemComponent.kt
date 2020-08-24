package ru.alexeypanchenko.mobuisdonor.add.di

import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.add.AddFragment
import ru.alexeypanchenko.mobuisdonor.add.AddInRoute
import ru.alexeypanchenko.mobuisdonor.add.dependencies.AddItemRepository

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