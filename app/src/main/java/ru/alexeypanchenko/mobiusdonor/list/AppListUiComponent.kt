package ru.alexeypanchenko.mobiusdonor.list

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.alexeypanchenko.mobiusdonor.add.di.AddItemComponent
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailComponent
import ru.alexeypanchenko.mobiusdonor.di.MainActivityComponent
import ru.alexeypanchenko.mobiusdonor.list.dependencies.ListOutRoute
import ru.alexeypanchenko.mobiusdonor.list.di.ListUiComponent
import ru.alexeypanchenko.mobiusdonor.list.di.ListUiScope
import ru.alexeypanchenko.mobiusdonor.settings.di.SettingsComponent

@ListUiScope
@Component(
    modules = [AppListUiModule::class],
    dependencies = [
        MainActivityComponent::class,
        DetailComponent::class,
        AddItemComponent::class,
        SettingsComponent::class
    ]
)
interface AppListUiComponent : ListUiComponent.Dependencies


@Module
abstract class AppListUiModule {

    @ListUiScope
    @Binds
    abstract fun getListOutRoute(routeImpl: AppListOutRoute): ListOutRoute

}