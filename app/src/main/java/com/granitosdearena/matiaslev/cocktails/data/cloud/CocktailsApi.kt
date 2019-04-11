package com.granitosdearena.matiaslev.cocktails.data.cloud

import com.granitosdearena.matiaslev.cocktails.data.cloud.model.CocktailCloud
import com.granitosdearena.matiaslev.cocktails.data.cloud.model.CocktailPreviewCloudList
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CocktailsApi {

    @GET("filter.php?g=Cocktail_glass")
    fun getCockailsPreview(): Single<CocktailPreviewCloudList>

    @GET
    fun getCocktail(@Path("id") id: String): CocktailCloud

}