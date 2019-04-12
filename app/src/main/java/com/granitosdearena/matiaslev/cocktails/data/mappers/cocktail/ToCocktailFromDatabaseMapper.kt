package com.granitosdearena.matiaslev.cocktails.data.mappers.cocktail

import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailDatabase
import com.granitosdearena.matiaslev.cocktails.data.mappers.BaseMapper
import com.granitosdearena.matiaslev.cocktails.domain.Cocktail

class ToCocktailFromDatabaseMapper: BaseMapper<CocktailDatabase, Cocktail> {

    override fun transform(input: CocktailDatabase): Cocktail =
        Cocktail(input.drinkName, input.drinkThumb, input.drinkId.toString())

    override fun transformToData(input: Cocktail): CocktailDatabase =
            CocktailDatabase(input.drinkId.toInt(), input.drinkName, input.drinkThumb)
}