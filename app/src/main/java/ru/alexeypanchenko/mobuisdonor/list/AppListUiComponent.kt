package ru.alexeypanchenko.mobuisdonor.list

import android.content.Intent
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.MainActivity
import ru.alexeypanchenko.mobuisdonor.R
import ru.alexeypanchenko.mobuisdonor.add.AddInRoute
import ru.alexeypanchenko.mobuisdonor.add.di.AddItemModule
import ru.alexeypanchenko.mobuisdonor.detail.DetailInRoute
import ru.alexeypanchenko.mobuisdonor.detail.DetailItem
import ru.alexeypanchenko.mobuisdonor.detail.di.DetailModule
import ru.alexeypanchenko.mobuisdonor.di.AppComponent
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListOutRoute
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponent
import ru.alexeypanchenko.mobuisdonor.list.di.ListUiComponent
import ru.alexeypanchenko.mobuisdonor.list.di.ListUiScope
import ru.alexeypanchenko.mobuisdonor.settings.SettingsActivity

@ListUiScope
@Component(modules = [AppListUiModule::class], dependencies = [AppComponent::class, ListComponent::class])
interface AppListUiComponent : ListUiComponent.Dependencies {
    fun inject(activity: MainActivity)
}

@Module(includes = [DetailModule::class, AddItemModule::class])
class AppListUiModule(
    private val activity: AppCompatActivity
) {

    @ListUiScope
    @Provides
    @IdRes
    fun getFragmentContainer(): Int {
        return R.id.container
    }

    @ListUiScope
    @Provides
    fun provideListRouter(@IdRes containerId: Int, listOutRoute: ListOutRoute): ListRouter {
        return ListRouter(activity, listOutRoute, activity.supportFragmentManager,  containerId)
    }

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