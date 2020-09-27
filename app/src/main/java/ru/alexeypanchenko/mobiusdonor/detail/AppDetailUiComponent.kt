package ru.alexeypanchenko.mobiusdonor.detail

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.alexeypanchenko.mobiusdonor.detail.dependencies.DetailOutRoute
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailUiComponent
import ru.alexeypanchenko.mobiusdonor.detail.di.DetailUiScope
import ru.alexeypanchenko.mobiusdonor.di.MainActivityComponent

@DetailUiScope
@Component(modules = [AppDetailUiModule::class], dependencies = [MainActivityComponent::class])
interface AppDetailUiComponent : DetailUiComponent.Dependencies

@Module
abstract class AppDetailUiModule {

    @DetailUiScope
    @Binds
    abstract fun getDetailOutRoute(routeImpl: AppDetailOutRoute): DetailOutRoute

}