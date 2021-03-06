package ru.alexeypanchenko.donorapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {

    @Query("SELECT * FROM items")
    fun getAll(): List<ItemEntry>

    @Query("SELECT * FROM items WHERE _id = :itemId LIMIT 1")
    fun getById(itemId: Int): ItemEntry?

    @Insert
    fun add(item: ItemEntry)

    @Query("DELETE FROM items WHERE _id = :itemId")
    fun removeById(itemId: Int)
}