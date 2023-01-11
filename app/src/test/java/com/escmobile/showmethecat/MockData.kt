package com.escmobile.showmethecat

import com.escmobile.showmethecat.data.model.CatFact
import com.escmobile.showmethecat.ui.viewModule.CatViewState
import retrofit2.Response

const val mockFact = "Mocked cats cannot fly. Normal cats cannot fly either."

object MockData {
    val mockCatFact = CatFact(mockFact, mockFact.length)
    val mockCatViewFact = CatViewState.Fact(mockCatFact)
    val mockCatFactResponseSuccess: Response<CatFact> = Response.success(mockCatFact)
}