package com.granitosdearena.matiaslev.cocktails.data.database

import androidx.paging.DataSource
import androidx.room.*
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailDatabase
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailPreviewDatabase
import io.reactivex.Observable

@Dao
interface CocktailPreviewDao {

    @Query("SELECT * FROM CocktailPreviewDatabase")
    fun getAll(): DataSource.Factory<Int, CocktailPreviewDatabase>

    @Query("SELECT * FROM CocktailPreviewDatabase WHERE idDrink IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<CocktailPreviewDatabase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplaceAll(cocktailPreviewDatabaseList: List<CocktailPreviewDatabase>)

    @Delete
    fun delete(user: CocktailPreviewDatabase)

}