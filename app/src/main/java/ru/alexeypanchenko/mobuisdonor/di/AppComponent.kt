package ru.alexeypanchenko.mobuisdonor.di

import dagger.Component
import ru.alexeypanchenko.mobuisdonor.add.AppAddItemModule
import ru.alexeypanchenko.mobuisdonor.add.di.AddItemDependencies
import ru.alexeypanchenko.mobuisdonor.db.DatabaseModule
import ru.alexeypanchenko.mobuisdonor.detail.AppDetailModule
import ru.alexeypanchenko.mobuisdonor.detail.di.DetailDependencies
import ru.alexeypanchenko.mobuisdonor.list.AppListModule
import ru.alexeypanchenko.mobuisdonor.list.di.ListDependencies
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