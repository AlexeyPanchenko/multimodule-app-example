package ru.alexeypanchenko.donorapp.add

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.alexeypanchenko.donorapp.add.dependencies.AddItemOutRoute
import ru.alexeypanchenko.donorapp.add.di.AddItemUiComponent
import ru.alexeypanchenko.donorapp.add.di.AddItemUiScope
import ru.alexeypanchenko.donorapp.di.MainActivityComponent

@AddItemUiScope
@Component(modules = [AppAddItemUiModule::class], dependencies = [MainActivityComponent::class])
interface AppAddItemUiComponent : AddItemUiComponent.Dependencies

@Module
abstract class AppAddItemUiModule {

    @AddItemUiScope
    @Binds
    abstract fun getDetailOutRoute(routeImpl: AppAddItemOutRoute): AddItemOutRoute

}