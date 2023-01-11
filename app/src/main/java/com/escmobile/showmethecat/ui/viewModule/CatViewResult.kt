package com.escmobile.showmethecat.ui.viewModule

import com.escmobile.showmethecat.data.model.CatFact

sealed class CatViewResult {
    data class Result(val result: CatFact) : CatViewResult()
    object NotSet : CatViewResult()
}