package ru.alexeypanchenko.mobiusdonor.di

import dagger.Component
import ru.alexeypanchenko.mobiusdonor.add.AppAddItemModule
import ru.alexeypanchenko.mobiusdonor.add.di.AddItemDependencies
import ru.alexeypanchenko.mobiusdonor.db.DatabaseModule
import ru.alexeypanchenko.mobiusdonor.detail.AppDetailModule
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailDependencies
import ru.alexeypanchenko.mobiusdonor.list.AppListModule
import ru.alexeypanchenko.mobiusdonor.list.di.ListDependencies
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AppListModule::class,
        AppDetailModule::class,
        AppAddItemModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent : ListDependencies, DetailDependencies, AddItemDependencies {
}