package ru.alexeypanchenko.mobiusdonor.list

import android.app.Activity
import android.content.Intent
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobiusdonor.add.AddInRoute
import ru.alexeypanchenko.mobiusdonor.add.di.AddItemModule
import ru.alexeypanchenko.mobiusdonor.detail.DetailInRoute
import ru.alexeypanchenko.mobiusdonor.detail.DetailItem
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailModule
import ru.alexeypanchenko.mobiusdonor.di.MainActivityComponent
import ru.alexeypanchenko.mobiusdonor.list.dependencies.ListOutRoute
import ru.alexeypanchenko.mobiusdonor.list.di.ListUiComponent
import ru.alexeypanchenko.mobiusdonor.list.di.ListUiScope
import ru.alexeypanchenko.mobiusdonor.settings.SettingsActivity

@ListUiScope
@Component(modules = [AppListUiModule::class], dependencies = [MainActivityComponent::class])
interface AppListUiComponent : ListUiComponent.Dependencies


@Module(includes = [DetailModule::class, AddItemModule::class])
class AppListUiModule {

    @ListUiScope
    @Provides
    fun getListOutRoute(
        activity: Activity,
        fragmentManager: FragmentManager,
        detailInRoute: DetailInRoute,
        addInRoute: AddInRoute,
        @IdRes containerId: Int
    ): ListOutRoute {
        return object : ListOutRoute {

            override fun openDetail(item: ListItem) {
                fragmentManager.beginTransaction().replace(
                    containerId,
                    detailInRoute.detailFragment(DetailItem(item.id, item.title, item.description))
                )
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }

            override fun openSettings() {
                activity.startActivity(Intent(activity, SettingsActivity::class.java))
            }

            override fun openAdd() {
                fragmentManager.beginTransaction()
                    .replace(containerId, addInRoute.getAddFragment())
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }

        }
    }

}