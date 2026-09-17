package com.example.finance.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

/** Application Room database; expand with feature entities and DAOs. */
@Database(entities = [AppMetaEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appMetaDao(): AppMetaDao
}