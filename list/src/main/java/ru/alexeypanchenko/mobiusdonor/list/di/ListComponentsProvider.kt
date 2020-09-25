package ru.alexeypanchenko.mobiusdonor.list.di

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

object ListComponentsProvider {

    private var listComponent: ListComponent? = null
    private var listUiDependencies: ListUiComponent.Dependencies? = null

    fun getListComponent(): ListComponent {
        return listComponent ?: throw IllegalStateException("ListComponent is not initialized!")
    }

    fun setListComponent(listComponent: ListComponent?) {
        this.listComponent = listComponent
    }

    fun getListUiComponentDependencies(): ListUiComponent.Dependencies {
        return listUiDependencies ?: throw IllegalStateException("ListUiComponent.Dependencies is not initialized!")
    }

    fun setListUiComponentDependencies(
        dependencies: ListUiComponent.Dependencies,
        lifecycle: Lifecycle
    ) {
        this.listUiDependencies = dependencies
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                listUiDependencies = null
            }
        })
    }

}