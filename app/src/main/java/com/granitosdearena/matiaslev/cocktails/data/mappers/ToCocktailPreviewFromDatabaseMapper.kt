package com.granitosdearena.matiaslev.cocktails.data.mappers

import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailPreviewDatabase
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview

class ToCocktailPreviewFromDatabaseMapper: BaseMapper<CocktailPreviewDatabase, CocktailPreview> {

    override fun transform(input: CocktailPreviewDatabase): CocktailPreview =
        CocktailPreview(input.drinkName, input.drinkThumb, input.idDrink.toString())

    override fun transformToData(input: CocktailPreview): CocktailPreviewDatabase {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}