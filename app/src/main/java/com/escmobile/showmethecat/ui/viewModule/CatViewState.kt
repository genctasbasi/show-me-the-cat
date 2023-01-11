package com.escmobile.showmethecat.ui.viewModule

import com.escmobile.showmethecat.data.model.CatFact

sealed class CatViewState {
    data class Fact(val result: CatFact) : CatViewState()
    object InProgress : CatViewState()
    object NotSet : CatViewState()
    object Error : CatViewState()
}