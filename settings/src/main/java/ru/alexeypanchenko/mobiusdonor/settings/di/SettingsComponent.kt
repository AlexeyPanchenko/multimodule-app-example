package ru.alexeypanchenko.mobiusdonor.settings.di

import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobiusdonor.settings.SettingsInRoute
import javax.inject.Singleton

@Singleton
@Component(modules = [SettingsModule::class])
interface SettingsComponent

@Module
class SettingsModule {

    @Provides
    fun getInRoute(): SettingsInRoute = SettingsInRoute()

}