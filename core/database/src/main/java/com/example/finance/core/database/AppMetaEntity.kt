package com.example.finance.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/** Internal metadata row to satisfy Room non-empty schema requirements. */
@Entity(tableName = "app_meta")
data class AppMetaEntity(
    @PrimaryKey val id: Int = 0,
    val schemaVersion: Int = 1,
)