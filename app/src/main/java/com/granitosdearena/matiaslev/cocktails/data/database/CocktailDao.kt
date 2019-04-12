package com.granitosdearena.matiaslev.cocktails.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailDatabase
import io.reactivex.Single

@Dao
interface CocktailDao {

    @Query("SELECT * FROM CocktailDatabase WHERE drinkId = :drinkId")
    fun searchCocktailById(drinkId: Int): Single<CocktailDatabase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(cocktailPreviewDatabaseList: CocktailDatabase)

}