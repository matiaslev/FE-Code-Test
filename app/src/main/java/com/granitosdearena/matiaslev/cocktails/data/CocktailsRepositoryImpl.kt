package com.granitosdearena.matiaslev.cocktails.data

import android.util.Log
import com.granitosdearena.matiaslev.cocktails.data.cloud.CocktailsApi
import com.granitosdearena.matiaslev.cocktails.data.model.CocktailPreviewMapper
import com.granitosdearena.matiaslev.cocktails.domain.Cocktail
import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository
import com.granitosdearena.matiaslev.cocktails.presentation.CocktailpreviewViewModel
import io.reactivex.schedulers.Schedulers

class CocktailsRepositoryImpl(val cocktailsApi: CocktailsApi): CocktailsRepository {

    override fun getCockailsPreview() = cocktailsApi.getCockailsPreview()
        .subscribeOn(Schedulers.io())
        .doOnError { Log.d(CocktailpreviewViewModel::class.java.canonicalName, it.message) }
        .map { CocktailPreviewMapper().transform(it) }

    override fun getCocktail(drinkId: String): Cocktail {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}