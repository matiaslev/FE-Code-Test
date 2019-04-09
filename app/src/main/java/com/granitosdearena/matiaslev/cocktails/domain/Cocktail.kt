package com.granitosdearena.matiaslev.cocktails.domain

data class Cocktail(
    override var drinkName: String = "",
    override var drinkThumb: String = "",
    override var drinkId: String = "",
    val category: String = "",
    val alcoholic: String = "",
    val glass: String = ""
): CocktailPreview(drinkName, drinkThumb, drinkId)