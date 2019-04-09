package com.granitosdearena.matiaslev.cocktails.data

import com.granitosdearena.matiaslev.cocktails.data.cloud.CocktailsApi
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class CocktailRepositoryImplTest {

    val cocktailsApi = mockk<CocktailsApi>(relaxed = true)
    val repositoryUnderTest = CocktailsRepositoryImpl(cocktailsApi)

    @Test
    fun `getCockailsPreview should return an observable with the current data in the database`() {
        // val repositoryResponse = repositoryUnderTest.getCockailsPreview()
        assertEquals(true, false) // TODO: Not yet
    }

    @Test
    fun `getCockailsPreview should call the api for update the previews from the database`() {
        repositoryUnderTest.getCockailsPreview()
        verify { cocktailsApi.getCockailsPreview() }
    }
}