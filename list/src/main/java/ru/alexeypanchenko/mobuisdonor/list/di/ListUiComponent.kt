package ru.alexeypanchenko.mobuisdonor.list.di

import dagger.Component
import ru.alexeypanchenko.mobuisdonor.list.ListFragment
import ru.alexeypanchenko.mobuisdonor.list.ListRouter
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListOutRoute
import javax.inject.Scope

@Scope
@Retention
annotation class ListUiScope

@ListUiScope
@Component(dependencies = [ListUiComponent.Dependencies::class, ListComponent::class])
interface ListUiComponent {
    fun inject(fragment: ListFragment)

    interface Dependencies {
        fun getListRouter(): ListRouter
        fun getListOutRoute(): ListOutRoute
    }
}
