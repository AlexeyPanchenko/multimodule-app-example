package ru.alexeypanchenko.mobiusdonor.list.di

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

    fun setListUiComponentDependencies(dependencies: ListUiComponent.Dependencies?) {
        this.listUiDependencies = dependencies
    }


}