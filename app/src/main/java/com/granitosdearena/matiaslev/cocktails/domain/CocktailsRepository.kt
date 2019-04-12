package com.granitosdearena.matiaslev.cocktails.domain

import androidx.paging.PagedList
import io.reactivex.Observable
import io.reactivex.Single

interface CocktailsRepository {
    // TODO: Not Use PagedList in domain!! we are coupled for this reason.
    fun syncCockailsPreview(): Observable<PagedList<CocktailPreview>>
    fun getCocktail(drinkId: String): Single<Cocktail>
}