package com.granitosdearena.matiaslev.cocktails.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview
import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository
import com.granitosdearena.matiaslev.cocktails.domain.GetCocktailsPreviewUseCase
import io.reactivex.Observable

class CocktailPreviewViewModel(private val getCocktailsPreviewUseCase: GetCocktailsPreviewUseCase): ViewModel() {

    fun getCockailsPreview(): Observable<PagedList<CocktailPreview>> = getCocktailsPreviewUseCase()

}

// TODO CODE TEST

// DRAW VIEW FOR COCKTAIL with all the fields

// RESPONSE QUESTION FOR THE CODE TEST OVER THE README

// BONUS SEARCH

// TODO Improvements

// THINK ANOTHER WAY TO DISPOSE OBSERVABLE THAT ON THE ON DESTROY FOR THE ACTIVITY

// !!!!optional!!!! room tests