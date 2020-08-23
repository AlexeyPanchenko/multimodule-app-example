package ru.alexeypanchenko.mobuisdonor

import android.app.Application
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponent
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponentProvider
import ru.alexeypanchenko.mobuisdonor.list.di.ListModule

class App : Application(), ListComponentProvider {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override lateinit var listComponent: ListComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule((this)))
            .build()

        listComponent = appComponent.plusListComponent(ListModule())


    }
}