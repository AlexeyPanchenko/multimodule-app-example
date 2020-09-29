package ru.alexeypanchenko.mobiusdonor.settings

import android.content.Context
import android.content.Intent

class SettingsInRoute {

    fun intent(context: Context): Intent = Intent(context, SettingsActivity::class.java)
}