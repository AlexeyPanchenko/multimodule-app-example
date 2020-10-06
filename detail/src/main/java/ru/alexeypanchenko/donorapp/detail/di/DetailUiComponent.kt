package ru.alexeypanchenko.donorapp.detail.di

import dagger.Component
import ru.alexeypanchenko.donorapp.detail.DetailFragment
import ru.alexeypanchenko.donorapp.detail.dependencies.DetailOutRoute
import javax.inject.Scope

@Scope
@Retention
annotation class DetailUiScope

@DetailUiScope
@Component(dependencies = [DetailUiComponent.Dependencies::class, DetailComponent::class])
interface DetailUiComponent {
    fun inject(fragment: DetailFragment)

    interface Dependencies {
        fun getDetailOutRoute(): DetailOutRoute
    }
}
