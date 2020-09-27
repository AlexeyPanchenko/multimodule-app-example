package ru.alexeypanchenko.mobiusdonor.detail.di

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

object DetailDependenciesProvider {

    private var detailComponent: DetailComponent? = null
    private var detailUiDependencies: DetailUiComponent.Dependencies? = null

    fun getDetailComponent(): DetailComponent {
        return detailComponent ?: throw IllegalStateException("DetailComponent is not initialized!")
    }

    fun setDetailComponent(detailComponent: DetailComponent?) {
        this.detailComponent = detailComponent
    }

    fun getDetailUiComponentDependencies(): DetailUiComponent.Dependencies {
        return detailUiDependencies ?: throw IllegalStateException("DetailUiComponent.Dependencies is not initialized!")
    }

    fun setDetailUiComponentDependencies(
        dependencies: DetailUiComponent.Dependencies,
        lifecycle: Lifecycle
    ) {
        this.detailUiDependencies = dependencies
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                detailUiDependencies = null
            }
        })
    }
}