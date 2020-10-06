package ru.alexeypanchenko.donorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.alexeypanchenko.donorapp.add.DaggerAppAddItemUiComponent
import ru.alexeypanchenko.donorapp.add.di.AddItemDependenciesProvider
import ru.alexeypanchenko.donorapp.detail.DaggerAppDetailUiComponent
import ru.alexeypanchenko.donorapp.detail.di.DetailDependenciesProvider
import ru.alexeypanchenko.donorapp.di.DaggerMainActivityComponent
import ru.alexeypanchenko.donorapp.di.MainActivityModule
import ru.alexeypanchenko.donorapp.list.DaggerAppListUiComponent
import ru.alexeypanchenko.donorapp.list.ListInRoute
import ru.alexeypanchenko.donorapp.list.di.ListComponentsProvider
import ru.alexeypanchenko.donorapp.settings.di.SettingsComponentProvider

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
