package com.granitosdearena.matiaslev.cocktails.data.cloud.model

import com.granitosdearena.matiaslev.cocktails.CocktailFactory
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailPreviewDatabase
import com.granitosdearena.matiaslev.cocktails.data.mappers.CocktailPreviewCloudToDatabaseMapper
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview
import org.junit.Assert.assertEquals
import org.junit.Test

class CocktailPreviewCloudToDatabaseMapperTest {

    private val mapperUnderTest = CocktailPreviewCloudToDatabaseMapper()

    @Test
    fun `transform should get CocktailPreviewDataList and return a list of CocktailPreview`() {
        val mapperResult = mapperUnderTest.transform(CocktailFactory.newCocktailPreviewCloudClass())
        assertEquals(CocktailPreviewDatabase::class, mapperResult.first()::class)
    }

    @Test
    fun `transformToData should get CocktailPreviewDataList and return `() {
        val mapperResult = mapperUnderTest.transformToData(CocktailFactory.newCocktailPreviewDatabaseList())
        assertEquals(CocktailPreviewCloudList::class, mapperResult::class)
    }

}