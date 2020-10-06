package ru.alexeypanchenko.donorapp.detail

import androidx.fragment.app.FragmentManager
import ru.alexeypanchenko.donorapp.detail.dependencies.DetailOutRoute
import javax.inject.Inject

class AppDetailOutRoute @Inject constructor(
    private val fragmentManager: FragmentManager
) : DetailOutRoute {

    override fun goBack() {
        fragmentManager.popBackStack()
    }
}