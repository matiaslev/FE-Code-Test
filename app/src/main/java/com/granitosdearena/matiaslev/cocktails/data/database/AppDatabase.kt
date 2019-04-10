package com.granitosdearena.matiaslev.cocktails.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailPreviewDatabase

@Database(entities = arrayOf(CocktailPreviewDatabase::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cocktailPreviewDao(): CocktailPreviewDao
}