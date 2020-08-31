package ru.alexeypanchenko.mobuisdonor.list

import android.app.Activity
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListOutRoute
import javax.inject.Inject

/**
 * [activity], [fragmentManager], [container] for inner transactions.
 */
class ListRouter @Inject constructor(
    private val activity: Activity,
    private val outRoute: ListOutRoute,
    private val fragmentManager: FragmentManager,
    @IdRes private val container: Int
) {

    fun openDetail(item: ListItem) {
        outRoute.openDetail(item)
    }

    fun openAdd() {
        outRoute.openAdd()
    }

    fun openSettings() {
        outRoute.openSettings()
    }

    fun goBack() {
        if (canGoBack()) {
            if (fragmentManager.isStateSaved) {
                return
            }
            fragmentManager.popBackStack()
        } else {
            activity.finish()
        }
    }

    private fun canGoBack(): Boolean = fragmentManager.backStackEntryCount > 1
}