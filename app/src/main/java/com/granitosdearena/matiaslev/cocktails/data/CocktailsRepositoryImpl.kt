package com.granitosdearena.matiaslev.cocktails.data

import com.granitosdearena.matiaslev.cocktails.data.cloud.CocktailsApi
import com.granitosdearena.matiaslev.cocktails.data.model.CocktailPreviewMapper
import com.granitosdearena.matiaslev.cocktails.domain.Cocktail
import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository

class CocktailsRepositoryImpl(val cocktailsApi: CocktailsApi): CocktailsRepository {

    override fun getCockailsPreview() = cocktailsApi.getCockailsPreview().map { it.map { CocktailPreviewMapper().transform(it) } }

    override fun getCocktail(drinkId: String): Cocktail {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}