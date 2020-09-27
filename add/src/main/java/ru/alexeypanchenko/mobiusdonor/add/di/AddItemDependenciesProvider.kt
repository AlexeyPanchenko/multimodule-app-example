package ru.alexeypanchenko.mobiusdonor.add.di

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

object AddItemDependenciesProvider {

    private var addItemComponent: AddItemComponent? = null
    private var uiDependencies: AddItemUiComponent.Dependencies? = null

    fun getAddItemComponent(): AddItemComponent {
        return addItemComponent ?: throw IllegalStateException("AddItemComponent is not initialized!")
    }

    fun setAddItemComponent(addItemComponent: AddItemComponent?) {
        this.addItemComponent = addItemComponent
    }

    fun getUiComponentDependencies(): AddItemUiComponent.Dependencies {
        return uiDependencies ?: throw IllegalStateException("AddItemUiComponent.Dependencies is not initialized!")
    }

    fun setUiComponentDependencies(
        dependencies: AddItemUiComponent.Dependencies,
        lifecycle: Lifecycle
    ) {
        this.uiDependencies = dependencies
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                uiDependencies = null
            }
        })
    }

}