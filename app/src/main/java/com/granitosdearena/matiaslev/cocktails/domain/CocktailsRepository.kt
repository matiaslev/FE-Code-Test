package com.granitosdearena.matiaslev.cocktails.domain

import io.reactivex.Observable

interface CocktailsRepository {
    fun syncCockailsPreview(): Observable<List<CocktailPreview>>
    fun getCocktail(drinkId: String): Cocktail
}