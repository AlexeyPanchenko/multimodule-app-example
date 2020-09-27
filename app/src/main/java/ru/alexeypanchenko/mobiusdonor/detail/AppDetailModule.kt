package ru.alexeypanchenko.mobiusdonor.detail

import dagger.Binds
import dagger.Module
import ru.alexeypanchenko.mobiusdonor.detail.dependencies.DetailItemRepository
import javax.inject.Singleton

@Module
abstract class AppDetailModule {

    @Singleton
    @Binds
    abstract fun getDetailRepository(detailRepository: AppDetailItemRepository): DetailItemRepository

}