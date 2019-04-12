package com.granitosdearena.matiaslev.cocktails.presentation

import androidx.room.Room
import com.granitosdearena.matiaslev.cocktails.data.CocktailsRepositoryImpl
import com.granitosdearena.matiaslev.cocktails.data.cloud.CocktailsApi
import com.granitosdearena.matiaslev.cocktails.data.database.AppDatabase
import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository
import com.granitosdearena.matiaslev.cocktails.domain.GetCocktailUseCase
import com.granitosdearena.matiaslev.cocktails.domain.GetCocktailsPreviewUseCase
import com.granitosdearena.matiaslev.cocktails.presentation.cocktailPreviewRecycler.CocktailPreviewAdapter
import com.granitosdearena.matiaslev.cocktails.presentation.viewModels.CocktailPreviewViewModel
import com.granitosdearena.matiaslev.cocktails.presentation.viewModels.CocktailViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitApiFactory {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

val appModule = module {

    factory { CocktailPreviewAdapter() }

    single<CocktailsApi> { RetrofitApiFactory.retrofit.create(CocktailsApi::class.java) }

    single { Room.databaseBuilder(androidContext(), AppDatabase::class.java, "database-name").build() }

    single<CocktailsRepository> { CocktailsRepositoryImpl(get(), get()) }

    single { GetCocktailsPreviewUseCase(get()) }

    single { GetCocktailUseCase(get()) }

    viewModel { CocktailPreviewViewModel(get()) }

    viewModel { CocktailViewModel(get()) }

}