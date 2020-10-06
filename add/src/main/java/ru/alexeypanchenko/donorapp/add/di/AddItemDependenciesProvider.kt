package ru.alexeypanchenko.donorapp.add.di

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

object AddItemDependenciesProvider {

    private var addItemComponentFactory: (() -> AddItemComponent?)? = null
    private var uiDependenciesFactory: (() -> AddItemUiComponent.Dependencies?)? = null
    private var addItemComponent: AddItemComponent? = null
    private var uiDependencies: AddItemUiComponent.Dependencies? = null

    fun getAddItemComponent(): AddItemComponent {
        if (addItemComponent == null) {
            addItemComponent = addItemComponentFactory?.invoke()
        }
        return addItemComponent ?: throw IllegalStateException("AddItemComponent is not initialized!")
    }

    fun setAddItemComponentFactory(factory: () -> AddItemComponent?) {
        this.addItemComponentFactory = factory
    }

    fun getUiComponentDependencies(): AddItemUiComponent.Dependencies {
        if (uiDependencies == null) {
            uiDependencies = uiDependenciesFactory?.invoke()
        }
        return uiDependencies ?: throw IllegalStateException("AddItemUiComponent.Dependencies is not initialized!")
    }

    fun setUiComponentDependenciesFactory(
        factory: () -> AddItemUiComponent.Dependencies?,
        lifecycle: Lifecycle
    ) {
        this.uiDependenciesFactory = factory
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                uiDependenciesFactory = null
                clearUiDependencies()
            }
        })
    }

    internal fun clearUiDependencies() {
        uiDependencies = null
    }

}