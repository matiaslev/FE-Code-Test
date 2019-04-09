package com.granitosdearena.matiaslev.cocktails.data.model

import com.granitosdearena.matiaslev.cocktails.CocktailFactory
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview
import org.junit.Assert.assertEquals
import org.junit.Test

class CocktailPreviewMapperTest {

    private val mapperUnderTest = CocktailPreviewMapper()

    @Test
    fun `transform should get CocktailPreviewDataList and return a list of CocktailPreview`() {
        val mapperResult = mapperUnderTest.transform(CocktailFactory.newCocktailPreviewDataClass())
        assertEquals(CocktailPreview::class, mapperResult.first()::class)
    }

    @Test
    fun `transformToData should get CocktailPreviewDataList and return `() {
        val mapperResult = mapperUnderTest.transformToData(CocktailFactory.newCocktailsPreviewList())
        assertEquals(CocktailPreviewDataList::class, mapperResult::class)
    }

}