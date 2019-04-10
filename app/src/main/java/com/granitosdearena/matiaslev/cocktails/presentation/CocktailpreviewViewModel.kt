package com.granitosdearena.matiaslev.cocktails.presentation

import androidx.lifecycle.ViewModel
import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class CocktailpreviewViewModel(private val cocktailPreviewRepository: CocktailsRepository): ViewModel() {

    fun getCockailsPreview() = cocktailPreviewRepository.syncCockailsPreview().observeOn(AndroidSchedulers.mainThread())

}