package ru.alexeypanchenko.donorapp.di

import dagger.Component
import ru.alexeypanchenko.donorapp.add.AppAddItemModule
import ru.alexeypanchenko.donorapp.add.di.AddItemDependencies
import ru.alexeypanchenko.donorapp.db.DatabaseModule
import ru.alexeypanchenko.donorapp.detail.AppDetailModule
import ru.alexeypanchenko.donorapp.detail.di.DetailDependencies
import ru.alexeypanchenko.donorapp.list.AppListModule
import ru.alexeypanchenko.donorapp.list.di.ListDependencies
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