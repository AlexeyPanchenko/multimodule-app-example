package ru.alexeypanchenko.mobuisdonor.detail.di
import androidx.fragment.app.Fragment
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.detail.DetailFragment
import ru.alexeypanchenko.mobuisdonor.detail.DetailInRoute
import ru.alexeypanchenko.mobuisdonor.detail.dependencies.DetailItemRepository

@Component(modules = [DetailModule::class], dependencies = [DetailDependencies::class])
interface DetailComponent {
    fun getInRoute(): DetailInRoute
    fun inject(fragment: DetailFragment)
}

interface DetailDependencies {
    fun getRepository(): DetailItemRepository
}

@Module
class DetailModule {

    @Provides
    fun getInRoute(): DetailInRoute = DetailInRoute()

}
