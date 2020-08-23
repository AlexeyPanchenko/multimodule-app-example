package ru.alexeypanchenko.mobuisdonor.list.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.alexeypanchenko.mobuisdonor.list.ListFragment
import ru.alexeypanchenko.mobuisdonor.list.R

@Subcomponent(modules = [ListModule::class])
interface ListComponent {
    fun inject(fragment: ListFragment)
}

@Module
class ListModule {

    @Provides
    fun getText(app: Application): String {
        return app.getString(R.string.list_text)
    }

}