package com.granitosdearena.matiaslev.cocktails.presentation

import androidx.lifecycle.ViewModel
import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository

class CocktailPreviewViewModel(private val cocktailPreviewRepository: CocktailsRepository): ViewModel() {

    fun getCockailsPreview() = cocktailPreviewRepository.syncCockailsPreview()

}