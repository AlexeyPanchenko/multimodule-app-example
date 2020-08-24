package ru.alexeypanchenko.mobuisdonor

import android.app.Application
import ru.alexeypanchenko.mobuisdonor.detail.di.DaggerDetailComponent
import ru.alexeypanchenko.mobuisdonor.detail.di.DetailComponent
import ru.alexeypanchenko.mobuisdonor.detail.di.DetailComponentProvider
import ru.alexeypanchenko.mobuisdonor.detail.di.DetailModule
import ru.alexeypanchenko.mobuisdonor.di.AppComponent
import ru.alexeypanchenko.mobuisdonor.di.AppComponentProvider
import ru.alexeypanchenko.mobuisdonor.di.AppModule
import ru.alexeypanchenko.mobuisdonor.di.DaggerAppComponent
import ru.alexeypanchenko.mobuisdonor.list.AppListModule
import ru.alexeypanchenko.mobuisdonor.list.di.DaggerListComponent
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponent
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponentProvider
import ru.alexeypanchenko.mobuisdonor.list.di.ListModule

class App : Application(), ListComponentProvider, AppComponentProvider, DetailComponentProvider {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var listComponent: ListComponent
    }

    override lateinit var appComponent: AppComponent
    override lateinit var listComponent: ListComponent
    override lateinit var detailComponent: DetailComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule((this)))
            .appListModule(AppListModule())
            .build()
        listComponent = DaggerListComponent.builder()
            .listModule(ListModule())
            .listDependencies(appComponent)
            .build()
        detailComponent = DaggerDetailComponent.builder()
            .detailModule(DetailModule())
            .detailDependencies(appComponent)
            .build()

        App.appComponent = appComponent
        App.listComponent = listComponent

    }
}