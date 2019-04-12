package com.granitosdearena.matiaslev.cocktails.presentation

import com.granitosdearena.matiaslev.cocktails.domain.GetCocktailsPreviewUseCase
import com.granitosdearena.matiaslev.cocktails.presentation.viewModels.CocktailPreviewViewModel
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class CocktailPreviewViewModelTest {

    val cocktailsPreviewUseCase = mockk<GetCocktailsPreviewUseCase>(relaxed = true)
    val viewModelUnderTest =
        CocktailPreviewViewModel(cocktailsPreviewUseCase)

    @Test
    fun `getCockailsPreview should ask to the repository for sync the CocktailsPreview`() {
        viewModelUnderTest.getCockailsPreview()
        verify { cocktailsPreviewUseCase() }
    }

}