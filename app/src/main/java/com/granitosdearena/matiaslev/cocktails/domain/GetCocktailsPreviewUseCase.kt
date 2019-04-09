package com.granitosdearena.matiaslev.cocktails.domain

import com.granitosdearena.matiaslev.cocktails.domain.CocktailsRepository

class GetCocktailsPreviewUseCase(val cockatilsRepository: CocktailsRepository) {
    operator fun invoke() = cockatilsRepository.getCockailsPreview()
}