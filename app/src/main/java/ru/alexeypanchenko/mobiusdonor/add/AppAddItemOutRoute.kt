package ru.alexeypanchenko.mobiusdonor.add

import androidx.fragment.app.FragmentManager
import ru.alexeypanchenko.mobiusdonor.add.dependencies.AddItemOutRoute
import javax.inject.Inject

class AppAddItemOutRoute @Inject constructor(
    private val fragmentManager: FragmentManager
) : AddItemOutRoute {

    override fun goBack() {
        fragmentManager.popBackStack()
    }
}