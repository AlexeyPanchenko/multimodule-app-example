package ru.alexeypanchenko.donorapp.detail

import dagger.Binds
import dagger.Module
import ru.alexeypanchenko.donorapp.detail.dependencies.DetailItemRepository
import javax.inject.Singleton

@Module
abstract class AppDetailModule {

    @Singleton
    @Binds
    abstract fun getDetailRepository(detailRepository: AppDetailItemRepository): DetailItemRepository

}