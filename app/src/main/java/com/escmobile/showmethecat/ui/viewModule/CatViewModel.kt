package com.escmobile.showmethecat.ui.viewModule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.escmobile.showmethecat.data.CatRepo
import com.escmobile.showmethecat.data.model.CatFact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatViewModel(private val repo: CatRepo) : ViewModel() {

    private val _catFactResult = MutableLiveData<CatViewResult>()
    val catFactResult: LiveData<CatViewResult> = _catFactResult

    fun getCatFact() {
        viewModelScope.launch(Dispatchers.IO) {
            val catFact = repo.getCatFact()

            // TODO: We handled potential network errors in the repo but another level of error handling could be added here if
            //  the catFact happens to be null. For the sake of the simplicity, here we're preferring not to let the user (activity)
            //  know, in case something went wrong.
            catFact?.let {
                _catFactResult.postValue(CatViewResult.Result(it))
            } ?: run {
                _catFactResult.postValue(CatViewResult.NotSet)
            }

        }
    }
}