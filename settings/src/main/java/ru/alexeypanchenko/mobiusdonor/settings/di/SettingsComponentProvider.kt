package ru.alexeypanchenko.mobiusdonor.settings.di

object SettingsComponentProvider {

    private var settingsComponentFactory: (() -> SettingsComponent?)? = null
    private var settingsComponent: SettingsComponent? = null

    fun getSettingsComponent(): SettingsComponent {
        if (settingsComponent == null) {
            settingsComponent = settingsComponentFactory?.invoke()
        }
        return settingsComponent ?: throw IllegalStateException("SettingsComponent is not initialized!")
    }

    fun setSettingsComponentFactory(factory: () -> SettingsComponent?) {
        this.settingsComponentFactory = factory
    }
}