package ru.alexeypanchenko.mobiusdonor.add.di

import dagger.Component
import ru.alexeypanchenko.mobiusdonor.add.AddFragment
import ru.alexeypanchenko.mobiusdonor.add.dependencies.AddItemOutRoute
import javax.inject.Scope

@Scope
@Retention
annotation class AddItemUiScope

@AddItemUiScope
@Component(dependencies = [AddItemUiComponent.Dependencies::class, AddItemComponent::class])
interface AddItemUiComponent {

    fun inject(fragment: AddFragment)

    interface Dependencies {
        fun getAddItemOutRoute(): AddItemOutRoute
    }
}