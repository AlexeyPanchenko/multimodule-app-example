package ru.alexeypanchenko.mobiusdonor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.alexeypanchenko.mobiusdonor.detail.DaggerAppDetailUiComponent
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailDependenciesProvider
import ru.alexeypanchenko.mobiusdonor.di.DaggerMainActivityComponent
import ru.alexeypanchenko.mobiusdonor.di.MainActivityModule
import ru.alexeypanchenko.mobiusdonor.list.DaggerAppListUiComponent
import ru.alexeypanchenko.mobiusdonor.list.ListInRoute
import ru.alexeypanchenko.mobiusdonor.list.di.ListComponentsProvider

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		val mainActivityComponent = DaggerMainActivityComponent.builder()
			.mainActivityModule(MainActivityModule(this))
			.build()
		ListComponentsProvider.setListUiComponentDependencies(
			DaggerAppListUiComponent.builder()
				.mainActivityComponent(mainActivityComponent)
				.build(),
			lifecycle
		)
		DetailDependenciesProvider.setDetailUiComponentDependencies(
			DaggerAppDetailUiComponent.builder()
				.mainActivityComponent(mainActivityComponent)
				.build(),
			lifecycle
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
}
