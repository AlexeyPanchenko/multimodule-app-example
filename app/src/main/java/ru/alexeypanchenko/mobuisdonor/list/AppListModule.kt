package ru.alexeypanchenko.mobuisdonor.list

import android.content.Intent
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.detail.DetailInRoute
import ru.alexeypanchenko.mobuisdonor.detail.DetailItem
import ru.alexeypanchenko.mobuisdonor.detail.di.DetailModule
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ItemsRepository
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListOutRoute
import ru.alexeypanchenko.mobuisdonor.settings.SettingsActivity
import ru.alexeypanchenko.mobuisdonor.R
import javax.inject.Singleton

@Module(includes = [DetailModule::class])
class AppListModule {

    @Provides
    @Singleton
    fun provideItemsRepository(): ItemsRepository {
        return object : ItemsRepository {
            override fun getItems(): List<ListItem> {
                return listOf(
                    ListItem(1, "Title1", "Description1"),
                    ListItem(2, "Title2", "Description2"),
                    ListItem(3, "Title3", "Description3"),
                    ListItem(4, "Title4", "Description4"),
                    ListItem(5, "Title5", "Description5"),
                    ListItem(6, "Title6", "Description6")
                )
            }
        }
    }

    @Provides
    @Singleton
    fun provideOutRoute(detailInRoute: DetailInRoute): ListOutRoute {
        return object : ListOutRoute {
            override fun openDetail(fragment: Fragment, item: ListItem) {
                fragment.requireActivity().supportFragmentManager.beginTransaction().replace(
                    R.id.container,
                    detailInRoute.detailFragment(DetailItem(item.id, item.title, item.description))
                )
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }

            override fun openSettings(fragment: Fragment) {
                fragment.startActivity(Intent(fragment.activity, SettingsActivity::class.java))
            }

        }
    }

}