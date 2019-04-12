package com.granitosdearena.matiaslev.cocktails.data

import com.granitosdearena.matiaslev.cocktails.CocktailFactory
import com.granitosdearena.matiaslev.cocktails.data.cloud.CocktailsApi
import com.granitosdearena.matiaslev.cocktails.data.database.AppDatabase
import com.granitosdearena.matiaslev.cocktails.data.mappers.cocktailPreview.CocktailPreviewCloudToDatabaseMapper
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Test

class CocktailRepositoryImplTest {

    val cocktailsApi = mockk<CocktailsApi>(relaxed = true)
    val database = mockk<AppDatabase>(relaxed = true)
    val repositoryUnderTest = CocktailsRepositoryImpl(cocktailsApi, database)

    @Test
    fun `getCockailsPreview should call the getCockailsPreview api`() {
        repositoryUnderTest.syncCockailsPreview()
        verify { cocktailsApi.getCockailsPreview() }
    }

    @Test
    fun `getCockailsPreview should save the data returned by the api`() {
        repositoryUnderTest.syncCockailsPreview()
        val apiResponse = Single.just(CocktailFactory.newCocktailPreviewCloudClass())
        every { cocktailsApi.getCockailsPreview() } returns apiResponse
        val processedApiResponse = apiResponse.map { CocktailPreviewCloudToDatabaseMapper()
            .transform(it) }
        processedApiResponse.map { verify { database.cocktailPreviewDao().insertOrReplaceAll(it) } }

    }

    @Test
    fun `getCockailsPreview should get the data from the database`() {
        repositoryUnderTest.syncCockailsPreview()
        verify { database.cocktailPreviewDao().getAll() }
    }

    @Test
    fun `getCocktail should call the getCocktail api`() {
        repositoryUnderTest.getCocktail("1")
        verify { cocktailsApi.getCocktail("1") }
    }
}