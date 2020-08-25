package ru.alexeypanchenko.mobuisdonor.db

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.mobuisdonor.ItemsRepository
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun getAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "items.db")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun getItemsDao(database: AppDatabase): ItemDao {
        return database.itemDao()
    }

    @Provides
    @Singleton
    fun provideItemsRepository(itemDao: ItemDao): ItemsRepository {
        return ItemsRepository(itemDao)
    }
}