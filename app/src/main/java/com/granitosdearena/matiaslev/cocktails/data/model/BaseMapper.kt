package com.granitosdearena.matiaslev.cocktails.data.model

interface BaseMapper<E, D> {
    fun transform(input: E): D
    fun transformToData(input: D): E
}