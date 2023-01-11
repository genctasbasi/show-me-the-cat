package com.escmobile.showmethecat.ui.viewModule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.escmobile.showmethecat.data.CatRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatViewModel(private val repo: CatRepo) : ViewModel() {

    private val _catFactResult = MutableLiveData<CatViewState>()
    val catFactResult: LiveData<CatViewState> = _catFactResult

    fun getCatFact() {
        viewModelScope.launch(Dispatchers.IO) {
            _catFactResult.postValue(CatViewState.InProgress)
            val catFact = repo.getCatFact()

            // TODO: We handled potential network errors in the repo but another level of error handling could be added here if
            //  the catFact happens to be null
            catFact?.let {
                _catFactResult.postValue(CatViewState.Fact(it))
            } ?: run {
                _catFactResult.postValue(CatViewState.Error)
            }

        }
    }
}