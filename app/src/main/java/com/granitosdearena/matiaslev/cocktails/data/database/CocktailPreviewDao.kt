package com.granitosdearena.matiaslev.cocktails.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailPreviewDatabase
import io.reactivex.Observable

@Dao
interface CocktailPreviewDao {

    @Query("SELECT * FROM CocktailPreviewDatabase")
    fun getAll(): Observable<List<CocktailPreviewDatabase>>

    @Query("SELECT * FROM CocktailPreviewDatabase WHERE idDrink IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<CocktailPreviewDatabase>

    @Insert
    fun insertAll(cocktailPreviewDatabaseList: List<CocktailPreviewDatabase>)

    @Delete
    fun delete(user: CocktailPreviewDatabase)

}