package ru.alexeypanchenko.mobuisdonor

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import ru.alexeypanchenko.mobuisdonor.di.AppComponentProvider
import ru.alexeypanchenko.mobuisdonor.list.AppListUiModule
import ru.alexeypanchenko.mobuisdonor.list.DaggerAppListUiComponent
import ru.alexeypanchenko.mobuisdonor.list.ListInRoute
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponentsProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

	@Inject
	lateinit var listInRoute: ListInRoute

	@IdRes
	@JvmField
	@field:[Inject]
	var containerId: Int = 0

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val appListUiComponent = DaggerAppListUiComponent.builder()
			.appListUiModule(AppListUiModule(this))
			.appComponent((application as AppComponentProvider).appComponent)
			.listComponent(ListComponentsProvider.getListComponent())
			.build()
		appListUiComponent.inject(this)
		ListComponentsProvider.setListUiComponentDependencies(appListUiComponent)

		setContentView(R.layout.activity_main)

		//val listInRoute: ListInRoute = ListComponentsProvider.getListComponent().getInRoute()

		if (savedInstanceState == null || supportFragmentManager.findFragmentById(containerId) == null) {
			supportFragmentManager
				.beginTransaction()
				.replace(containerId, listInRoute.listFragment())
				.commitAllowingStateLoss()

		}
	}
}
