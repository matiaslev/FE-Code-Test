package com.granitosdearena.matiaslev.cocktails.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview
import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository
import io.reactivex.Observable

class CocktailPreviewViewModel(private val cocktailPreviewRepository: CocktailsRepository): ViewModel() {

    fun getCockailsPreview(): Observable<PagedList<CocktailPreview>> = cocktailPreviewRepository.syncCockailsPreview()

}