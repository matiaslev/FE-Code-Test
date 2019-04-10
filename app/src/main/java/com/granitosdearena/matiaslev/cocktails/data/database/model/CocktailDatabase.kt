package com.granitosdearena.matiaslev.cocktails.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CocktailDatabase(
    @PrimaryKey var uid: Int,
    var drinkName: String?,
    var drinkThumb: String?,
    var drinkId: String?
)