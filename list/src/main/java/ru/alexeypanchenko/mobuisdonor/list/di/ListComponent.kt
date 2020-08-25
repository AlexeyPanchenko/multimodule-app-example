package ru.alexeypanchenko.mobuisdonor.list.di

import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.list.ListFragment
import ru.alexeypanchenko.mobuisdonor.list.ListInRoute
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListItemsRepository
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListOutRoute

@Component(modules = [ListModule::class], dependencies = [ListDependencies::class])
interface ListComponent {
    fun getInRoute(): ListInRoute
    fun inject(fragment: ListFragment)
}

interface ListDependencies {
    fun getItemsRepository(): ListItemsRepository
    fun getOutRoute(): ListOutRoute
}

@Module
class ListModule {

    @Provides
    fun getInRoute(): ListInRoute = ListInRoute()

}