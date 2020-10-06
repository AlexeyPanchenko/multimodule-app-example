package ru.alexeypanchenko.donorapp.list.di

import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.donorapp.list.ListInRoute
import ru.alexeypanchenko.donorapp.list.dependencies.ListItemsRepository
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