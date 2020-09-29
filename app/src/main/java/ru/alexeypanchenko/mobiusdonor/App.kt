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
import ru.alexeypanchenko.mobiusdonor.settings.di.DaggerSettingsComponent
import ru.alexeypanchenko.mobiusdonor.settings.di.SettingsComponentProvider
import ru.alexeypanchenko.mobiusdonor.settings.di.SettingsModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule((this)))
            .build()
        ListComponentsProvider.setListComponentFactory {
            DaggerListComponent.builder()
                .listModule(ListModule())
                .listDependencies(appComponent)
                .build()
        }
        DetailDependenciesProvider.setDetailComponentFactory {
            DaggerDetailComponent.builder()
                .detailModule(DetailModule())
                .detailDependencies(appComponent)
                .build()
        }
        AddItemDependenciesProvider.setAddItemComponentFactory {
            DaggerAddItemComponent.builder()
                .addItemModule(AddItemModule())
                .addItemDependencies(appComponent)
                .build()
        }
        SettingsComponentProvider.setSettingsComponentFactory {
            DaggerSettingsComponent.builder()
                .settingsModule(SettingsModule())
                .build()
        }
    }
}