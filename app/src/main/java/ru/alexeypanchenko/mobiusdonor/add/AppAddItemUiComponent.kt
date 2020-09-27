package ru.alexeypanchenko.mobiusdonor.add

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.alexeypanchenko.mobiusdonor.add.dependencies.AddItemOutRoute
import ru.alexeypanchenko.mobiusdonor.add.di.AddItemUiComponent
import ru.alexeypanchenko.mobiusdonor.add.di.AddItemUiScope
import ru.alexeypanchenko.mobiusdonor.di.MainActivityComponent

@AddItemUiScope
@Component(modules = [AppAddItemUiModule::class], dependencies = [MainActivityComponent::class])
interface AppAddItemUiComponent : AddItemUiComponent.Dependencies

@Module
abstract class AppAddItemUiModule {

    @AddItemUiScope
    @Binds
    abstract fun getDetailOutRoute(routeImpl: AppAddItemOutRoute): AddItemOutRoute

}