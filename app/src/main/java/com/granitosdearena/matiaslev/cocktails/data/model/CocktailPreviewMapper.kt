package com.granitosdearena.matiaslev.cocktails.data.model

import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview

class CocktailPreviewMapper: BaseMapper<CocktailPreviewDataList, List<CocktailPreview>> {

    override fun transform(input: CocktailPreviewDataList) =
        input.drinks.map { CocktailPreview(it.strDrink, it.strDrinkThumb, it.idDrink) }

    override fun transformToData(input: List<CocktailPreview>) = CocktailPreviewDataList(
        input.map {
            CocktailPreviewData(it.drinkName, it.drinkThumb, it.drinkId)
        }
    )

}