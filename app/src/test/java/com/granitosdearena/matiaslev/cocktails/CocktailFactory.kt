package com.granitosdearena.matiaslev.cocktails

import com.granitosdearena.matiaslev.cocktails.data.model.CocktailPreviewData
import com.granitosdearena.matiaslev.cocktails.data.model.CocktailPreviewDataList
import com.granitosdearena.matiaslev.cocktails.domain.Cocktail
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview

object CocktailFactory {

    val name = "Crazy Cocktail"
    val thumb = "Crazy_Cocktail.jpg"
    val id = "1"

    fun newCocktail() = Cocktail(name, thumb, id)

    fun newCocktailsPreviewList() = listOf(
        newCocktailPreview(),
        newCocktailPreview(),
        newCocktailPreview(),
        newCocktailPreview(),
        newCocktailPreview()
    )

    fun newCocktailPreview() = CocktailPreview(name, thumb, id)

    fun newCocktailPreviewDataClass() = CocktailPreviewDataList(newCocktailPreviewDataList())

    fun newCocktailPreviewDataList() = listOf(
        newCocktailPreviewData(),
        newCocktailPreviewData(),
        newCocktailPreviewData(),
        newCocktailPreviewData()
    )

    fun newCocktailPreviewData() = CocktailPreviewData(name, thumb, id)

}