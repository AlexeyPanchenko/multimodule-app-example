package ru.alexeypanchenko.donorapp

import android.app.Application
import ru.alexeypanchenko.donorapp.add.di.AddItemDependenciesProvider
import ru.alexeypanchenko.donorapp.add.di.AddItemModule
import ru.alexeypanchenko.donorapp.add.di.DaggerAddItemComponent
import ru.alexeypanchenko.donorapp.detail.di.DaggerDetailComponent
import ru.alexeypanchenko.donorapp.detail.di.DetailDependenciesProvider
import ru.alexeypanchenko.donorapp.detail.di.DetailModule
import ru.alexeypanchenko.donorapp.di.AppModule
import ru.alexeypanchenko.donorapp.di.DaggerAppComponent
import ru.alexeypanchenko.donorapp.list.di.DaggerListComponent
import ru.alexeypanchenko.donorapp.list.di.ListComponentsProvider
import ru.alexeypanchenko.donorapp.list.di.ListModule
import ru.alexeypanchenko.donorapp.settings.di.DaggerSettingsComponent
import ru.alexeypanchenko.donorapp.settings.di.SettingsComponentProvider
import ru.alexeypanchenko.donorapp.settings.di.SettingsModule

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