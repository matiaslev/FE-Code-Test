package com.granitosdearena.matiaslev.cocktails.data.cloud.model

data class CocktailCloudList(val drinks: List<CocktailCloud>)

data class CocktailCloud(
    var strDrink: String,
    var strDrinkThumb: String,
    var idDrink: String
)