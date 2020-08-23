package ru.alexeypanchenko.mobuisdonor.list

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ItemsRepository
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListOutRoute
import ru.alexeypanchenko.mobuisdonor.settings.SettingsActivity
import javax.inject.Singleton

@Module
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
    fun provideOutRoute(): ListOutRoute {
        return object : ListOutRoute {
            override fun openDetail(fragment: Fragment, item: ListItem) {
                Toast.makeText(fragment.activity, "${item}", Toast.LENGTH_SHORT).show()
            }

            override fun openSettings(fragment: Fragment) {
                fragment.startActivity(Intent(fragment.activity, SettingsActivity::class.java))
            }

        }
    }


}