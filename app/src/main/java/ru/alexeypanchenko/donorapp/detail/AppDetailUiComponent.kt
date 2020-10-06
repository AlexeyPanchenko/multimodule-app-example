package ru.alexeypanchenko.donorapp.detail

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.alexeypanchenko.donorapp.detail.dependencies.DetailOutRoute
import ru.alexeypanchenko.donorapp.detail.di.DetailUiComponent
import ru.alexeypanchenko.donorapp.detail.di.DetailUiScope
import ru.alexeypanchenko.donorapp.di.MainActivityComponent

@DetailUiScope
@Component(modules = [AppDetailUiModule::class], dependencies = [MainActivityComponent::class])
interface AppDetailUiComponent : DetailUiComponent.Dependencies

@Module
abstract class AppDetailUiModule {

    @DetailUiScope
    @Binds
    abstract fun getDetailOutRoute(routeImpl: AppDetailOutRoute): DetailOutRoute

}