package com.granitosdearena.matiaslev.cocktails.presentation

import androidx.lifecycle.ViewModel
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview
import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository
import io.reactivex.Observable

class CocktailPreviewViewModel(private val cocktailPreviewRepository: CocktailsRepository): ViewModel() {

    fun getCockailsPreview(): Observable<List<CocktailPreview>> = cocktailPreviewRepository.syncCockailsPreview()

}