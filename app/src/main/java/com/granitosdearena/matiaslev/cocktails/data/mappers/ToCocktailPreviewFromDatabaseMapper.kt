package com.granitosdearena.matiaslev.cocktails.data.mappers

import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailPreviewDatabase
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview

class ToCocktailPreviewFromDatabaseMapper: BaseMapper<List<CocktailPreviewDatabase>, List<CocktailPreview>> {

    override fun transform(input: List<CocktailPreviewDatabase>): List<CocktailPreview> =
        input.map { CocktailPreview(it.drinkName, it.drinkThumb, it.idDrink.toString()) }

    override fun transformToData(input: List<CocktailPreview>): List<CocktailPreviewDatabase> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}