package com.granitosdearena.matiaslev.cocktails.data.mappers

import com.granitosdearena.matiaslev.cocktails.data.cloud.model.CocktailCloud
import com.granitosdearena.matiaslev.cocktails.data.database.model.CocktailDatabase

class CocktailCloudToDatabaseMapper: BaseMapper<CocktailCloud, CocktailDatabase> {

    override fun transform(input: CocktailCloud): CocktailDatabase {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformToData(input: CocktailDatabase): CocktailCloud {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}