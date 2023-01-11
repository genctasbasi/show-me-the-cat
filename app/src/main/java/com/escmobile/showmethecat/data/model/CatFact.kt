package com.escmobile.showmethecat.data.model

data class CatFact(val fact: String, val length: Int){
    override fun toString() = "Fact is $fact and its length is $length"
}