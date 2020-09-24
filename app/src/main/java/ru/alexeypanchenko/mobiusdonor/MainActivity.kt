package ru.alexeypanchenko.mobiusdonor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.alexeypanchenko.mobiusdonor.di.DaggerMainActivityComponent
import ru.alexeypanchenko.mobiusdonor.di.MainActivityModule
import ru.alexeypanchenko.mobiusdonor.list.AppListUiModule
import ru.alexeypanchenko.mobiusdonor.list.DaggerAppListUiComponent
import ru.alexeypanchenko.mobiusdonor.list.ListInRoute
import ru.alexeypanchenko.mobiusdonor.list.di.ListComponentsProvider

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
