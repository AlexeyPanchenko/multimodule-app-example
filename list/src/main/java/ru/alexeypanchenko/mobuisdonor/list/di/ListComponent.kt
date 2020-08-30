package ru.alexeypanchenko.mobuisdonor.list.di

import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.list.ListInRoute
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListItemsRepository
import javax.inject.Singleton

@Singleton
@Component(modules = [ListModule::class], dependencies = [ListDependencies::class])
interface ListComponent {
    fun getItemsRepository(): ListItemsRepository
    fun getInRoute(): ListInRoute
}

interface ListDependencies {
    fun getItemsRepository(): ListItemsRepository
}

@Module
class ListModule {

    @Provides
    @Singleton
    fun getInRoute(): ListInRoute = ListInRoute()

}