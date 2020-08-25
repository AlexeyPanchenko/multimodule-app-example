package ru.alexeypanchenko.mobuisdonor

import ru.alexeypanchenko.mobuisdonor.db.ItemEntry
import ru.alexeypanchenko.mobuisdonor.db.ItemDao

class ItemsRepository(
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
}