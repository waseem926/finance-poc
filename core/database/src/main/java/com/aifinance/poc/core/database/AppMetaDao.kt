package com.aifinance.poc.core.database

import androidx.room.Dao
import androidx.room.Query

/** Minimal DAO to satisfy Room configuration; extend per feature. */
@Dao
interface AppMetaDao {
    @Query("SELECT * FROM app_meta LIMIT 1")
    suspend fun load(): AppMetaEntity?
}