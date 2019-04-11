package com.granitosdearena.matiaslev.cocktails.data.mappers

import com.granitosdearena.matiaslev.cocktails.CocktailFactory
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailPreviewDatabase
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview
import org.junit.Assert
import org.junit.Test

class ToCocktailPreviewFromDatabaseMapperTest {

    private val mapperUnderTest = ToCocktailPreviewFromDatabaseMapper()

    @Test
    fun `transform should get CocktailPreviewDatabase and return CocktailPreview`() {
        val mapperResult = mapperUnderTest.transform(CocktailFactory.newCocktailPreviewDatabase())
        Assert.assertEquals(CocktailPreview::class, mapperResult::class)
    }

    @Test
    fun `transformToData should get CocktailPreview and return CocktailPreviewDatabase`() {
        val mapperResult = mapperUnderTest.transformToData(CocktailFactory.newCocktailPreview())
        Assert.assertEquals(CocktailPreviewDatabase::class, mapperResult::class)
    }

}