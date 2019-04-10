package com.granitosdearena.matiaslev.cocktails.presentation

import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class CocktailPreviewViewModelTest {

    val cocktailRepository = mockk<CocktailsRepository>(relaxed = true)
    val viewModelUnderTest = CocktailPreviewViewModel(cocktailRepository)

    @Test
    fun `getCockailsPreview should ask to the repository for sync the CocktailsPreview`() {
        viewModelUnderTest.getCockailsPreview()
        verify { cocktailRepository.syncCockailsPreview() }
    }

}