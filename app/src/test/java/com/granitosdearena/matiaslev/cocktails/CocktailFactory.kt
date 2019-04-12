package com.granitosdearena.matiaslev.cocktails

import com.granitosdearena.matiaslev.cocktails.data.cloud.model.CocktailCloud
import com.granitosdearena.matiaslev.cocktails.data.cloud.model.CocktailCloudList
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailPreviewDatabase
import com.granitosdearena.matiaslev.cocktails.data.cloud.model.CocktailPreviewCloud
import com.granitosdearena.matiaslev.cocktails.data.cloud.model.CocktailPreviewCloudList
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailDatabase
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

    fun newCocktailCloudClass() = CocktailCloudList(newCocktailCloudList())

    fun newCocktailCloudList() = listOf(newCocktailCloud())

    fun newCocktailCloud() = CocktailCloud(name, thumb, id)

    fun newCocktailDatabase() = CocktailDatabase(id.toInt(), name, thumb)

    fun newCocktailPreview() = CocktailPreview(name, thumb, id)

    fun newCocktailPreviewCloudClass() = CocktailPreviewCloudList(newCocktailPreviewCloudList())

    fun newCocktailPreviewCloudList() = listOf(
        newCocktailPreviewCloud(),
        newCocktailPreviewCloud(),
        newCocktailPreviewCloud(),
        newCocktailPreviewCloud()
    )

    fun newCocktailPreviewCloud() = CocktailPreviewCloud(name, thumb, id)

    fun newCocktailPreviewDatabaseList() = listOf(newCocktailPreviewDatabase())

    fun newCocktailPreviewDatabase() =
        CocktailPreviewDatabase(id.toInt(), name, thumb)

}