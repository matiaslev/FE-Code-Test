package com.granitosdearena.matiaslev.cocktails.data.cloud

import com.granitosdearena.matiaslev.cocktails.data.model.CocktailData
import com.granitosdearena.matiaslev.cocktails.data.model.CocktailPreviewData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface CocktailsApi {

    @GET("filter.php?g=Cocktail_glass")
    fun getCockailsPreview(): Observable<List<CocktailPreviewData>>

    @GET
    fun getCocktail(@Path("id") id: String): CocktailData

}