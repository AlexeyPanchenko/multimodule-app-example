package ru.alexeypanchenko.mobuisdonor

import android.app.Application
import ru.alexeypanchenko.mobuisdonor.di.AppComponent
import ru.alexeypanchenko.mobuisdonor.di.AppComponentProvider
import ru.alexeypanchenko.mobuisdonor.di.AppModule
import ru.alexeypanchenko.mobuisdonor.di.DaggerAppComponent
import ru.alexeypanchenko.mobuisdonor.list.AppListModule
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponent
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponentProvider
import ru.alexeypanchenko.mobuisdonor.list.di.ListModule

class App : Application(), ListComponentProvider, AppComponentProvider {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var listComponent: ListComponent
    }

    override lateinit var appComponent: AppComponent
    override lateinit var listComponent: ListComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule((this)))
            .appListModule(AppListModule())
            .build()
        listComponent = appComponent.plusListComponent(ListModule())

        App.appComponent = appComponent
        App.listComponent = listComponent

    }
}