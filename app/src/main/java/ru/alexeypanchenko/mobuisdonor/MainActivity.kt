package ru.alexeypanchenko.mobuisdonor

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import ru.alexeypanchenko.mobuisdonor.list.ListFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		//App.appComponent.inject(this)

		supportFragmentManager.beginTransaction().replace(R.id.container, ListFragment()).commitAllowingStateLoss()
	}
}