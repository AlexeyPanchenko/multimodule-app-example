package ru.alexeypanchenko.mobiusdonor.list

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.alexeypanchenko.mobiusdonor.add.di.AddItemModule
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailModule
import ru.alexeypanchenko.mobiusdonor.di.MainActivityComponent
import ru.alexeypanchenko.mobiusdonor.list.dependencies.ListOutRoute
import ru.alexeypanchenko.mobiusdonor.list.di.ListUiComponent
import ru.alexeypanchenko.mobiusdonor.list.di.ListUiScope

@ListUiScope
@Component(modules = [AppListUiModule::class], dependencies = [MainActivityComponent::class])
interface AppListUiComponent : ListUiComponent.Dependencies


@Module(includes = [DetailModule::class, AddItemModule::class])
abstract class AppListUiModule {

    @ListUiScope
    @Binds
    abstract fun getListOutRoute(routeImpl: AppListOutRoute): ListOutRoute

}