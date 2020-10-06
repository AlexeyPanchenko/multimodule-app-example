package ru.alexeypanchenko.donorapp.list.di

import dagger.Component
import ru.alexeypanchenko.donorapp.list.ListFragment
import ru.alexeypanchenko.donorapp.list.ListRouter
import ru.alexeypanchenko.donorapp.list.dependencies.ListOutRoute
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
