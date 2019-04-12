package com.granitosdearena.matiaslev.cocktails.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.granitosdearena.matiaslev.cocktails.domain.Cocktail
import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository
import io.reactivex.Observable

class CocktailViewModel(val cocktailsRepository: CocktailsRepository): ViewModel() {

    fun getCockailById(cocktailId: String): Observable<Cocktail> = cocktailsRepository.getCocktail(cocktailId)

}