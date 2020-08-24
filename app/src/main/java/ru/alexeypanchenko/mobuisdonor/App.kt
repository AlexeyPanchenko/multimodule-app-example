package ru.alexeypanchenko.mobuisdonor

import android.app.Application
import ru.alexeypanchenko.mobuisdonor.add.di.AddItemComponent
import ru.alexeypanchenko.mobuisdonor.add.di.AddItemComponentProvider
import ru.alexeypanchenko.mobuisdonor.add.di.AddItemModule
import ru.alexeypanchenko.mobuisdonor.add.di.DaggerAddItemComponent
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

class App :
    Application(),
    ListComponentProvider,
    AppComponentProvider,
    DetailComponentProvider,
    AddItemComponentProvider {

    override lateinit var appComponent: AppComponent
    override lateinit var listComponent: ListComponent
    override lateinit var detailComponent: DetailComponent
    override lateinit var addItemComponent: AddItemComponent

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
        addItemComponent = DaggerAddItemComponent.builder()
            .addItemModule(AddItemModule())
            .addItemDependencies(appComponent)
            .build()

    }
}