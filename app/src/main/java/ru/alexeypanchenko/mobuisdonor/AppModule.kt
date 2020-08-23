package ru.alexeypanchenko.mobuisdonor

import android.app.Application
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.list.ListItem
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ItemsRepository
import javax.inject.Singleton


@Module
class AppModule(
    private val app: Application
) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return app
    }


}