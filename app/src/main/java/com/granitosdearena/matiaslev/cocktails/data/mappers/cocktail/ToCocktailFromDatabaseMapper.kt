package com.granitosdearena.matiaslev.cocktails.data.mappers.cocktail

import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailDatabase
import com.granitosdearena.matiaslev.cocktails.data.mappers.BaseMapper
import com.granitosdearena.matiaslev.cocktails.domain.Cocktail

class ToCocktailFromDatabaseMapper: BaseMapper<CocktailDatabase,Cocktail> {

    override fun transform(input: CocktailDatabase): Cocktail {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformToData(input: Cocktail): CocktailDatabase {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}