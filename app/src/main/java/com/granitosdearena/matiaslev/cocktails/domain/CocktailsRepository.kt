package com.granitosdearena.matiaslev.cocktails.domain

import io.reactivex.Observable

interface CocktailsRepository {
    fun getCockailsPreview(): Observable<List<CocktailPreview>>
    fun getCocktail(drinkId: String): Cocktail
}