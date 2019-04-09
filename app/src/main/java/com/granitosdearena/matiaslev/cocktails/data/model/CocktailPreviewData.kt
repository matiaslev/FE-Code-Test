package com.granitosdearena.matiaslev.cocktails.data.model

data class CocktailPreviewDataList(val drinks: List<CocktailPreviewData>)

data class CocktailPreviewData(
    var strDrink: String,
    var strDrinkThumb: String,
    var idDrink: String)