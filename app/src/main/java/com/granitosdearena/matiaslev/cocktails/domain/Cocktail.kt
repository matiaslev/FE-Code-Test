package com.granitosdearena.matiaslev.cocktails.domain

data class Cocktail(
    override var drinkId: String = "",
    override var drinkName: String = "",
    override var drinkThumb: String = "",
    var drinkInstructions: String,
    var drinkIngredients: List<String>,
    var drinkMeasures: List<String>
): CocktailPreview(drinkName, drinkThumb, drinkId)