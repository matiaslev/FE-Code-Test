package com.granitosdearena.matiaslev.cocktails.data.mappers.cocktail

import com.granitosdearena.matiaslev.cocktails.data.cloud.model.CocktailCloud
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailDatabase
import com.granitosdearena.matiaslev.cocktails.data.mappers.BaseMapper

class CocktailCloudToDatabaseMapper: BaseMapper<CocktailCloud, CocktailDatabase> {

    override fun transform(input: CocktailCloud): CocktailDatabase =
        CocktailDatabase(
            input.idDrink.toInt(),
            input.strDrink,
            input.strDrinkThumb,
            input.strInstructions,
            getIngredients(input),
            getMeasures(input))

    private fun getIngredients(input: CocktailCloud): List<String> {
        val mutableListOfIngredients = mutableListOf<String>()
        if(input.strIngredient1.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient1)
        if(input.strIngredient2.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient2)
        if(input.strIngredient3.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient3)
        if(input.strIngredient4.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient4)
        if(input.strIngredient5.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient5)
        if(input.strIngredient6.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient6)
        if(input.strIngredient7.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient7)
        if(input.strIngredient8.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient8)
        if(input.strIngredient9.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient9)
        if(input.strIngredient10.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient10)
        if(input.strIngredient11.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient11)
        if(input.strIngredient12.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient12)
        if(input.strIngredient13.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient13)
        if(input.strIngredient14.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient14)
        if(input.strIngredient15.isNotEmpty()) mutableListOfIngredients.add(input.strIngredient15)
        return mutableListOfIngredients
    }

    private fun getMeasures(input: CocktailCloud): List<String> {
        val mutableListOfMeasures = mutableListOf<String>()
        if(input.strMeasure1.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure1)
        if(input.strMeasure2.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure2)
        if(input.strMeasure3.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure3)
        if(input.strMeasure4.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure4)
        if(input.strMeasure5.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure5)
        if(input.strMeasure6.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure6)
        if(input.strMeasure7.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure7)
        if(input.strMeasure8.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure8)
        if(input.strMeasure9.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure9)
        if(input.strMeasure10.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure10)
        if(input.strMeasure11.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure11)
        if(input.strMeasure12.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure12)
        if(input.strMeasure13.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure13)
        if(input.strMeasure14.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure14)
        if(input.strMeasure15.isNotEmpty()) mutableListOfMeasures.add(input.strMeasure15)
        return mutableListOfMeasures
    }
}