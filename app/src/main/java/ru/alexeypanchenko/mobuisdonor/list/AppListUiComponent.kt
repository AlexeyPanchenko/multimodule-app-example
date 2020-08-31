package ru.alexeypanchenko.mobuisdonor.list

import android.content.Intent
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.add.AddInRoute
import ru.alexeypanchenko.mobuisdonor.add.di.AddItemModule
import ru.alexeypanchenko.mobuisdonor.detail.DetailInRoute
import ru.alexeypanchenko.mobuisdonor.detail.DetailItem
import ru.alexeypanchenko.mobuisdonor.detail.di.DetailModule
import ru.alexeypanchenko.mobuisdonor.di.MainActivityComponent
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListOutRoute
import ru.alexeypanchenko.mobuisdonor.list.di.ListUiComponent
import ru.alexeypanchenko.mobuisdonor.list.di.ListUiScope
import ru.alexeypanchenko.mobuisdonor.settings.SettingsActivity

@ListUiScope
@Component(modules = [AppListUiModule::class], dependencies = [MainActivityComponent::class])
interface AppListUiComponent : ListUiComponent.Dependencies


@Module(includes = [DetailModule::class, AddItemModule::class])
class AppListUiModule(
    private val activity: AppCompatActivity
) {

    @ListUiScope
    @Provides
    fun getListOutRoute(
        detailInRoute: DetailInRoute,
        addInRoute: AddInRoute,
        @IdRes containerId: Int
    ): ListOutRoute {
        return object : ListOutRoute {

            override fun openDetail(item: ListItem) {
               activity.supportFragmentManager.beginTransaction().replace(
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
                activity.supportFragmentManager.beginTransaction()
                    .replace(containerId, addInRoute.getAddFragment())
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }

        }
    }

}