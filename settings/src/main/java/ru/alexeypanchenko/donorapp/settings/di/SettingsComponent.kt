package ru.alexeypanchenko.donorapp.settings.di

import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.donorapp.settings.SettingsInRoute
import javax.inject.Singleton

@Singleton
@Component(modules = [SettingsModule::class])
interface SettingsComponent {
    fun getSettingsInRoute(): SettingsInRoute
}

@Module
class SettingsModule {

    @Provides
    @Singleton
    fun getInRoute(): SettingsInRoute = SettingsInRoute()

}