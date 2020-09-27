package ru.alexeypanchenko.mobiusdonor

import ru.alexeypanchenko.mobiusdonor.db.ItemDao
import ru.alexeypanchenko.mobiusdonor.db.ItemEntry
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemsRepository @Inject constructor(
    private val itemsDao: ItemDao
) {

    fun addItem(item: ItemEntry) {
        itemsDao.add(item)
    }

    fun getAll(): List<ItemEntry> {
        return itemsDao.getAll()
    }

    fun getById(itemId: Int): ItemEntry? {
        return itemsDao.getById(itemId)
    }

    fun removeById(itemId: Int) {
        itemsDao.removeById(itemId)
    }
}