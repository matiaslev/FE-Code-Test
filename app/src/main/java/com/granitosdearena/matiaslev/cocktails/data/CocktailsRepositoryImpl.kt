package com.granitosdearena.matiaslev.cocktails.data

import android.util.Log
import androidx.paging.PagedList
import androidx.paging.toObservable
import com.granitosdearena.matiaslev.cocktails.data.cloud.CocktailsApi
import com.granitosdearena.matiaslev.cocktails.data.database.AppDatabase
import com.granitosdearena.matiaslev.cocktails.data.mappers.cocktail.CocktailCloudToDatabaseMapper
import com.granitosdearena.matiaslev.cocktails.data.mappers.cocktail.ToCocktailFromDatabaseMapper
import com.granitosdearena.matiaslev.cocktails.data.mappers.cocktailPreview.CocktailPreviewCloudToDatabaseMapper
import com.granitosdearena.matiaslev.cocktails.data.mappers.cocktailPreview.ToCocktailPreviewFromDatabaseMapper
import com.granitosdearena.matiaslev.cocktails.domain.Cocktail
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview
import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository
import com.granitosdearena.matiaslev.cocktails.presentation.viewModels.CocktailPreviewViewModel
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CocktailsRepositoryImpl(val cocktailsApi: CocktailsApi, val database: AppDatabase): CocktailsRepository {

    override fun syncCockailsPreview(): Observable<PagedList<CocktailPreview>> {
        val disposable = cocktailsApi.getCockailsPreview()
            .subscribeOn(Schedulers.io())
            .doOnError { Log.d(CocktailPreviewViewModel::class.java.canonicalName, it.message) }
            .map { database.cocktailPreviewDao().insertAll(CocktailPreviewCloudToDatabaseMapper().transform(it)) }
            .subscribeBy(
                onError =  { it.printStackTrace() },
                onSuccess = {  }
            )

        return database.cocktailPreviewDao().getAll()
            .map { ToCocktailPreviewFromDatabaseMapper()
                .transform(it) }
            .toObservable(10)
    }

    override fun getCocktail(drinkId: String): Observable<Cocktail> {
        val disposable = cocktailsApi.getCocktail(drinkId)
            .subscribeOn(Schedulers.io())
            .doOnError { Log.d(CocktailPreviewViewModel::class.java.canonicalName, it.message) }
            .filter { it.drinks.isNotEmpty() }
            .map { database.cocktailDao().insert(CocktailCloudToDatabaseMapper().transform(it.drinks.first())) }
            .subscribeBy(
                onError =  { it.printStackTrace() },
                onSuccess = {  }
            )

        return database.cocktailDao().searchCocktailById(drinkId.toInt())
            .map { ToCocktailFromDatabaseMapper().transform(it) }
    }
}