package com.granitosdearena.matiaslev.cocktails

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
}