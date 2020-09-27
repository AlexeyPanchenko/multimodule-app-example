package ru.alexeypanchenko.mobiusdonor.detail.di

import dagger.Component
import ru.alexeypanchenko.mobiusdonor.detail.DetailFragment
import ru.alexeypanchenko.mobiusdonor.detail.dependencies.DetailOutRoute
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
