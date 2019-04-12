package com.granitosdearena.matiaslev.cocktails.data.mappers.cocktail

import com.granitosdearena.matiaslev.cocktails.data.cloud.model.CocktailCloud
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailDatabase
import com.granitosdearena.matiaslev.cocktails.data.mappers.BaseMapper

class CocktailCloudToDatabaseMapper: BaseMapper<CocktailCloud, CocktailDatabase> {

    override fun transform(input: CocktailCloud): CocktailDatabase =
        CocktailDatabase(input.idDrink.toInt(), input.strDrink, input.strDrinkThumb)

    override fun transformToData(input: CocktailDatabase): CocktailCloud =
        CocktailCloud(input.drinkName, input.drinkThumb, input.drinkId.toString())

}