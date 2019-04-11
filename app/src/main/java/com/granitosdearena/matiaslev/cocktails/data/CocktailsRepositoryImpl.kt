package com.granitosdearena.matiaslev.cocktails.data

import android.util.Log
import androidx.paging.PagedList
import androidx.paging.toObservable
import com.granitosdearena.matiaslev.cocktails.data.cloud.CocktailsApi
import com.granitosdearena.matiaslev.cocktails.data.database.AppDatabase
import com.granitosdearena.matiaslev.cocktails.data.mappers.CocktailPreviewCloudToDatabaseMapper
import com.granitosdearena.matiaslev.cocktails.data.mappers.ToCocktailPreviewFromDatabaseMapper
import com.granitosdearena.matiaslev.cocktails.domain.Cocktail
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview
import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository
import com.granitosdearena.matiaslev.cocktails.presentation.CocktailPreviewViewModel
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CocktailsRepositoryImpl(val cocktailsApi: CocktailsApi, val database: AppDatabase): CocktailsRepository {

    override fun syncCockailsPreview(): Observable<PagedList<CocktailPreview>> {
        val disposable = cocktailsApi.getCockailsPreview()
            .subscribeOn(Schedulers.io())
            .doOnError { Log.d(CocktailPreviewViewModel::class.java.canonicalName, it.message) }
            .map { database.cocktailPreviewDao().insertOrReplaceAll(CocktailPreviewCloudToDatabaseMapper().transform(it)) }
            .subscribeBy(
                onError =  { it.printStackTrace() },
                onSuccess = {  }
            )

        return database.cocktailPreviewDao().getAll()
            .map { ToCocktailPreviewFromDatabaseMapper().transform(it) }
            .toObservable(10)
    }

    override fun getCocktail(drinkId: String): Cocktail {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}