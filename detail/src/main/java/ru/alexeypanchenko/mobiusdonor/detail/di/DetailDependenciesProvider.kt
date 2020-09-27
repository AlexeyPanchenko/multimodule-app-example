package ru.alexeypanchenko.mobiusdonor.detail.di

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

object DetailDependenciesProvider {

    private var detailComponentFactory: (() -> DetailComponent?)? = null
    private var detailUiDependenciesFactory: (() -> DetailUiComponent.Dependencies?)? = null
    private var detailComponent: DetailComponent? = null
    private var detailUiDependencies: DetailUiComponent.Dependencies? = null

    fun getDetailComponent(): DetailComponent {
        if (detailComponent == null) {
            detailComponent = detailComponentFactory?.invoke()
        }
        return detailComponent ?: throw IllegalStateException("DetailComponent is not initialized!")
    }

    fun setDetailComponentFactory(detailComponentFactory: () -> DetailComponent?) {
        this.detailComponentFactory = detailComponentFactory
    }

    fun getDetailUiComponentDependencies(): DetailUiComponent.Dependencies {
        if (detailUiDependencies == null) {
            detailUiDependencies = detailUiDependenciesFactory?.invoke()
        }
        return detailUiDependencies ?: throw IllegalStateException("DetailUiComponent.Dependencies is not initialized!")
    }

    fun setDetailUiComponentDependenciesFactory(
        factory: (() -> DetailUiComponent.Dependencies?)?,
        lifecycle: Lifecycle
    ) {
        this.detailUiDependenciesFactory = factory
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                detailUiDependenciesFactory = null
                clearUiDependencies()
            }
        })
    }

    internal fun clearUiDependencies() {
        detailUiDependencies = null
    }
}