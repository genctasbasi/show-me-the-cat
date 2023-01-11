package com.escmobile.showmethecat.data

import com.escmobile.showmethecat.data.model.CatFact
import retrofit2.Response
import retrofit2.http.GET

const val BASE_URL = "https://catfact.ninja/"
const val CAT_IMAGES_URL = "https://cataas.com/cat/says/"

interface CatAPI {
    @GET("/fact")
    suspend fun getCatFact() : Response<CatFact>
d
    @GET("/facts")
    suspend fun getCatFacts() : Response<List<CatFact>>
}