package ru.alexeypanchenko.mobiusdonor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.alexeypanchenko.mobiusdonor.add.DaggerAppAddItemUiComponent
import ru.alexeypanchenko.mobiusdonor.add.di.AddItemDependenciesProvider
import ru.alexeypanchenko.mobiusdonor.detail.DaggerAppDetailUiComponent
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailDependenciesProvider
import ru.alexeypanchenko.mobiusdonor.di.DaggerMainActivityComponent
import ru.alexeypanchenko.mobiusdonor.di.MainActivityModule
import ru.alexeypanchenko.mobiusdonor.list.DaggerAppListUiComponent
import ru.alexeypanchenko.mobiusdonor.list.ListInRoute
import ru.alexeypanchenko.mobiusdonor.list.di.ListComponentsProvider
import ru.alexeypanchenko.mobiusdonor.settings.di.SettingsComponentProvider

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		initDependenciesProviders()
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		if (savedInstanceState == null || supportFragmentManager.findFragmentById(R.id.container) == null) {
			val listInRoute: ListInRoute = ListComponentsProvider.getListComponent().getInRoute()
			supportFragmentManager
				.beginTransaction()
				.replace(R.id.container, listInRoute.listFragment())
				.commitAllowingStateLoss()
		}
	}

	private fun initDependenciesProviders() {
		val mainActivityComponent = DaggerMainActivityComponent.builder()
			.mainActivityModule(MainActivityModule(this))
			.build()
		ListComponentsProvider.setListUiComponentDependenciesFactory(
			{
				DaggerAppListUiComponent.builder()
					.mainActivityComponent(mainActivityComponent)
					.detailComponent(DetailDependenciesProvider.getDetailComponent())
					.addItemComponent(AddItemDependenciesProvider.getAddItemComponent())
					.settingsComponent(SettingsComponentProvider.getSettingsComponent())
					.build()
			},
			lifecycle
		)
		DetailDependenciesProvider.setDetailUiComponentDependenciesFactory(
			{
				DaggerAppDetailUiComponent.builder()
					.mainActivityComponent(mainActivityComponent)
					.build()
			},
			lifecycle
		)
		AddItemDependenciesProvider.setUiComponentDependenciesFactory(
			{
				DaggerAppAddItemUiComponent.builder()
					.mainActivityComponent(mainActivityComponent)
					.build()
			},
			lifecycle
		)
	}
}
