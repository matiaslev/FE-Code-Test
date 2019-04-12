package com.granitosdearena.matiaslev.cocktails.data.mappers.cocktail

import com.granitosdearena.matiaslev.cocktails.CocktailFactory
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailDatabase
import com.granitosdearena.matiaslev.cocktails.domain.Cocktail
import org.junit.Assert.assertEquals
import org.junit.Test

class ToCocktailFromDatabaseMapperTest {

    private val mapperUnderTest = ToCocktailFromDatabaseMapper()

    @Test
    fun `transform should get CocktailDatabase and return Cocktail`() {
        val mapperResult = mapperUnderTest.transform(CocktailFactory.newCocktailDatabase())
        assertEquals(Cocktail::class, mapperResult::class)
    }

    @Test
    fun `transformToData should get Cocktail and return CocktailDatabase`() {
        val mapperResult = mapperUnderTest.transformToData(CocktailFactory.newCocktail())
        assertEquals(CocktailDatabase::class, mapperResult::class)
    }

}