package ru.alexeypanchenko.mobiusdonor

import android.app.Application
import ru.alexeypanchenko.mobiusdonor.add.di.AddItemDependenciesProvider
import ru.alexeypanchenko.mobiusdonor.add.di.AddItemModule
import ru.alexeypanchenko.mobiusdonor.add.di.DaggerAddItemComponent
import ru.alexeypanchenko.mobiusdonor.detail.di.DaggerDetailComponent
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailDependenciesProvider
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailModule
import ru.alexeypanchenko.mobiusdonor.di.AppModule
import ru.alexeypanchenko.mobiusdonor.di.DaggerAppComponent
import ru.alexeypanchenko.mobiusdonor.list.di.DaggerListComponent
import ru.alexeypanchenko.mobiusdonor.list.di.ListComponentsProvider
import ru.alexeypanchenko.mobiusdonor.list.di.ListModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule((this)))
            .build()
        val listComponent = DaggerListComponent.builder()
            .listModule(ListModule())
            .listDependencies(appComponent)
            .build()
        ListComponentsProvider.setListComponent(listComponent)
        val detailComponent = DaggerDetailComponent.builder()
            .detailModule(DetailModule())
            .detailDependencies(appComponent)
            .build()
        DetailDependenciesProvider.setDetailComponent(detailComponent)
        val addItemComponent = DaggerAddItemComponent.builder()
            .addItemModule(AddItemModule())
            .addItemDependencies(appComponent)
            .build()
        AddItemDependenciesProvider.setAddItemComponent(addItemComponent)
    }
}