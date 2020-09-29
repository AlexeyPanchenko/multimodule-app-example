package ru.alexeypanchenko.mobiusdonor.list

import android.app.Activity
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import ru.alexeypanchenko.mobiusdonor.add.AddInRoute
import ru.alexeypanchenko.mobiusdonor.detail.DetailInRoute
import ru.alexeypanchenko.mobiusdonor.detail.DetailItem
import ru.alexeypanchenko.mobiusdonor.list.dependencies.ListOutRoute
import ru.alexeypanchenko.mobiusdonor.settings.SettingsInRoute
import javax.inject.Inject

class AppListOutRoute @Inject constructor(
    private val activity: Activity,
    private val fragmentManager: FragmentManager,
    private val detailInRoute: DetailInRoute,
    private val settingsInRoute: SettingsInRoute,
    private val addInRoute: AddInRoute,
    @IdRes private val containerId: Int
) : ListOutRoute {

    override fun openDetail(item: ListItem) {
        fragmentManager.beginTransaction().replace(
            containerId,
            detailInRoute.detailFragment(DetailItem(item.id, item.title, item.description))
        )
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }

    override fun openSettings() {
        activity.startActivity(settingsInRoute.intent(activity))
    }

    override fun openAdd() {
        fragmentManager.beginTransaction()
            .replace(containerId, addInRoute.getAddFragment())
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }

}