package ru.alexeypanchenko.mobuisdonor.list.di

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.alexeypanchenko.mobuisdonor.list.ListFragment
import ru.alexeypanchenko.mobuisdonor.list.ListInRoute

@Subcomponent(modules = [ListModule::class])
interface ListComponent {
    fun getInRoute(): ListInRoute
    fun inject(fragment: ListFragment)
}

@Module
class ListModule {

    @Provides
    fun getInRoute(): ListInRoute = ListInRoute()

}