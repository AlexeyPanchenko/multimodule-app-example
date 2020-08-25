package ru.alexeypanchenko.mobuisdonor.list

import android.content.Intent
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.ItemsRepository
import ru.alexeypanchenko.mobuisdonor.detail.DetailInRoute
import ru.alexeypanchenko.mobuisdonor.detail.DetailItem
import ru.alexeypanchenko.mobuisdonor.detail.di.DetailModule
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListItemsRepository
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListOutRoute
import ru.alexeypanchenko.mobuisdonor.settings.SettingsActivity
import ru.alexeypanchenko.mobuisdonor.R
import ru.alexeypanchenko.mobuisdonor.add.AddInRoute
import ru.alexeypanchenko.mobuisdonor.add.di.AddItemModule
import javax.inject.Singleton

@Module(includes = [DetailModule::class, AddItemModule::class])
class AppListModule {

    @Provides
    @Singleton
    fun provideListItemsRepository(itemsRepository: ItemsRepository): ListItemsRepository {
        return object : ListItemsRepository {
            override fun getItems(): List<ListItem> {
                return itemsRepository.getAll().map { ListItem(it.id, it.title, it.description) }
            }
        }
    }

    @Provides
    @Singleton
    fun provideOutRoute(
        detailInRoute: DetailInRoute,
        addInRoute: AddInRoute
    ): ListOutRoute {
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

            override fun openAdd(fragment: Fragment) {
                fragment.requireActivity().supportFragmentManager.beginTransaction().replace(
                    R.id.container, addInRoute.getAddFragment()
                )
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }

        }
    }

}