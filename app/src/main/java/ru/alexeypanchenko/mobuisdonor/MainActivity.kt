package ru.alexeypanchenko.mobuisdonor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.alexeypanchenko.mobuisdonor.list.ListInRoute
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponentProvider

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContentView(R.layout.activity_main)

		val listInRoute: ListInRoute = (application as ListComponentProvider).listComponent.getInRoute()

		if (savedInstanceState == null || supportFragmentManager.findFragmentById(R.id.container) == null) {
			supportFragmentManager
				.beginTransaction()
				.replace(R.id.container, listInRoute.listFragment())
				.commitAllowingStateLoss()

		}
	}
}