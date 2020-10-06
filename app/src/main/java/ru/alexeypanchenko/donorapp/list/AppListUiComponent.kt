package ru.alexeypanchenko.donorapp.list

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.alexeypanchenko.donorapp.add.di.AddItemComponent
import ru.alexeypanchenko.donorapp.detail.di.DetailComponent
import ru.alexeypanchenko.donorapp.di.MainActivityComponent
import ru.alexeypanchenko.donorapp.list.dependencies.ListOutRoute
import ru.alexeypanchenko.donorapp.list.di.ListUiComponent
import ru.alexeypanchenko.donorapp.list.di.ListUiScope
import ru.alexeypanchenko.donorapp.settings.di.SettingsComponent

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