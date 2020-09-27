package ru.alexeypanchenko.mobiusdonor.list.di

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

object ListComponentsProvider {

    private var listComponentFactory: (() -> ListComponent?)? = null
    private var listUiDependenciesFactory: (() -> ListUiComponent.Dependencies?)? = null
    private var listComponent: ListComponent? = null
    private var listUiDependencies: ListUiComponent.Dependencies? = null

    fun getListComponent(): ListComponent {
        if (listComponent == null) {
            listComponent = listComponentFactory?.invoke()
        }
        return listComponent ?: throw IllegalStateException("ListComponent is not initialized!")
    }

    fun setListComponentFactory(factory: () -> ListComponent?) {
        this.listComponentFactory = factory
    }

    fun getListUiComponentDependencies(): ListUiComponent.Dependencies {
        if (listUiDependencies == null) {
            listUiDependencies = listUiDependenciesFactory?.invoke()
        }
        return listUiDependencies ?: throw IllegalStateException("ListUiComponent.Dependencies is not initialized!")
    }

    fun setListUiComponentDependenciesFactory(
        factory: (() -> ListUiComponent.Dependencies?)?,
        lifecycle: Lifecycle
    ) {
        this.listUiDependenciesFactory = factory
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                listUiDependenciesFactory = null
                clearUiDependencies()
            }
        })
    }

    internal fun clearUiDependencies() {
        listUiDependencies = null
    }

}