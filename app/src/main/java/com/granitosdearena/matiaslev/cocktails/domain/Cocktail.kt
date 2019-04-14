package com.granitosdearena.matiaslev.cocktails.domain

data class Cocktail(
    override var drinkId: String = "",
    override var drinkName: String = "",
    override var drinkThumb: String = "",
    var drinkInstructions: String,
    private var drinkIngredients: List<String>,
    private var drinkMeasures: List<String>
): CocktailPreview(drinkName, drinkThumb, drinkId) {

    fun getIngredientsWithMeasures(): String {
        var ingredientsWithMeasuresText = ""
        drinkMeasures.forEachIndexed { index, measure ->
            ingredientsWithMeasuresText += "$measure - ${drinkIngredients[index]} \n"
        }
        return ingredientsWithMeasuresText
    }

}