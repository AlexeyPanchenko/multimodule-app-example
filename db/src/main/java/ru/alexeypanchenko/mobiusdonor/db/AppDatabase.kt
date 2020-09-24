package ru.alexeypanchenko.mobiusdonor.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ItemEntry::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}