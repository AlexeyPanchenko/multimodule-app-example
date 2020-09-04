package ru.alexeypanchenko.mobuisdonor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.alexeypanchenko.mobuisdonor.di.DaggerMainActivityComponent
import ru.alexeypanchenko.mobuisdonor.di.MainActivityModule
import ru.alexeypanchenko.mobuisdonor.list.AppListUiModule
import ru.alexeypanchenko.mobuisdonor.list.DaggerAppListUiComponent
import ru.alexeypanchenko.mobuisdonor.list.ListInRoute
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponentsProvider

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		ListComponentsProvider.setListUiComponentDependencies(
			DaggerAppListUiComponent.builder()
				.appListUiModule(AppListUiModule())
				.mainActivityComponent(
					DaggerMainActivityComponent.builder()
						.mainActivityModule(MainActivityModule(this))
						.build()
				)
				.build()
		)

		super.onCreate(savedInstanceState)

		setContentView(R.layout.activity_main)

		val listInRoute: ListInRoute = ListComponentsProvider.getListComponent().getInRoute()

		if (savedInstanceState == null || supportFragmentManager.findFragmentById(R.id.container) == null) {
			supportFragmentManager
				.beginTransaction()
				.replace(R.id.container, listInRoute.listFragment())
				.commitAllowingStateLoss()

		}
	}

	override fun onDestroy() {
		super.onDestroy()
		ListComponentsProvider.setListUiComponentDependencies(null)
	}
}
