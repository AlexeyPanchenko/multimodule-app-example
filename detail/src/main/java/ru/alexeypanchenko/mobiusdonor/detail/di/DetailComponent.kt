package ru.alexeypanchenko.mobiusdonor.detail.di
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobiusdonor.detail.DetailFragment
import ru.alexeypanchenko.mobiusdonor.detail.DetailInRoute
import ru.alexeypanchenko.mobiusdonor.detail.dependencies.DetailItemRepository

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
