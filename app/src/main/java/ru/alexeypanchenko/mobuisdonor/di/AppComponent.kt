package ru.alexeypanchenko.mobuisdonor.di

import dagger.Component
import ru.alexeypanchenko.mobuisdonor.MainActivity
import ru.alexeypanchenko.mobuisdonor.detail.AppDetailModule
import ru.alexeypanchenko.mobuisdonor.detail.di.DetailDependencies
import ru.alexeypanchenko.mobuisdonor.list.AppListModule
import ru.alexeypanchenko.mobuisdonor.list.di.ListDependencies
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AppListModule::class, AppDetailModule::class])
interface AppComponent : ListDependencies, DetailDependencies {
    fun inject(activity: MainActivity)
}