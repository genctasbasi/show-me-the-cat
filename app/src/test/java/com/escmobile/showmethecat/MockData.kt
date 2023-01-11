package com.escmobile.showmethecat

import com.escmobile.showmethecat.data.model.CatFact
import com.escmobile.showmethecat.ui.viewModule.CatViewResult
import retrofit2.Response

const val mockFact = "Mocked cats cannot fly. Normal cats cannot fly either."

object MockData {
    val mockCatFact = CatFact(mockFact, mockFact.length)
    val mockCatViewResult = CatViewResult.Result(mockCatFact)
    val mockCatFactResponseSuccess: Response<CatFact> = Response.success(mockCatFact)
}