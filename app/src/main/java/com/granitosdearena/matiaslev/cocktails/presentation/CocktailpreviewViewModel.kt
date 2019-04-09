package com.granitosdearena.matiaslev.cocktails.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class CocktailpreviewViewModel(private val cocktailPreviewRepository: CocktailsRepository): ViewModel() {

    fun getCockailsPreview() = cocktailPreviewRepository.getCockailsPreview().observeOn(AndroidSchedulers.mainThread())

}