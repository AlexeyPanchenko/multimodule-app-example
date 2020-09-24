package ru.alexeypanchenko.mobiusdonor

import android.app.Application
import ru.alexeypanchenko.mobiusdonor.add.di.AddItemComponent
import ru.alexeypanchenko.mobiusdonor.add.di.AddItemComponentProvider
import ru.alexeypanchenko.mobiusdonor.add.di.AddItemModule
import ru.alexeypanchenko.mobiusdonor.add.di.DaggerAddItemComponent
import ru.alexeypanchenko.mobiusdonor.detail.di.DaggerDetailComponent
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailComponent
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailComponentProvider
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailModule
import ru.alexeypanchenko.mobiusdonor.di.AppComponent
import ru.alexeypanchenko.mobiusdonor.di.AppComponentProvider
import ru.alexeypanchenko.mobiusdonor.di.AppModule
import ru.alexeypanchenko.mobiusdonor.di.DaggerAppComponent
import ru.alexeypanchenko.mobiusdonor.list.AppListModule
import ru.alexeypanchenko.mobiusdonor.list.di.DaggerListComponent
import ru.alexeypanchenko.mobiusdonor.list.di.ListComponentsProvider
import ru.alexeypanchenko.mobiusdonor.list.di.ListModule

class App :
    Application(),
    AppComponentProvider,
    DetailComponentProvider,
    AddItemComponentProvider {

    override lateinit var appComponent: AppComponent
    override lateinit var detailComponent: DetailComponent
    override lateinit var addItemComponent: AddItemComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule((this)))
            .appListModule(AppListModule())
            .build()
        val listComponent = DaggerListComponent.builder()
            .listModule(ListModule())
            .listDependencies(appComponent)
            .build()
        ListComponentsProvider.setListComponent(listComponent)
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