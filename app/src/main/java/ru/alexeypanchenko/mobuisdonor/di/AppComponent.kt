package ru.alexeypanchenko.mobuisdonor.di

import dagger.Component
import ru.alexeypanchenko.mobuisdonor.MainActivity
import ru.alexeypanchenko.mobuisdonor.list.AppListModule
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponent
import ru.alexeypanchenko.mobuisdonor.list.di.ListModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AppListModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun plusListComponent(module: ListModule): ListComponent
}