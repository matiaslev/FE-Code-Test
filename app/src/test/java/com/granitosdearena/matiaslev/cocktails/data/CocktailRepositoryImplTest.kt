package com.granitosdearena.matiaslev.cocktails.data

import com.granitosdearena.matiaslev.cocktails.data.cloud.CocktailsApi
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class CocktailRepositoryImplTest {

    val cocktailsApi = mockk<CocktailsApi>(relaxed = true)
    val repositoryUnderTest = CocktailsRepositoryImpl(cocktailsApi)


    // getCockailsPreview

    @Test
    fun `getCockailsPreview should call the getCockailsPreview api`() {
        repositoryUnderTest.getCockailsPreview()
        verify { cocktailsApi.getCockailsPreview() }
    }

    @Test
    fun `getCockailsPreview should save the data returned by the api`() {
        //repositoryUnderTest.saveCocktailsPreview()
        //verify { roomDatabase.saveCocktailsPreview() }
    }

    // getCocktail

    @Test
    fun `getCocktail should call the getCocktail api`() {
        repositoryUnderTest.getCocktail("1")
        verify { cocktailsApi.getCocktail("1") }
    }
}