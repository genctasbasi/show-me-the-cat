package com.escmobile.showmethecat.data

import com.escmobile.showmethecat.data.model.CatFact
import timber.log.Timber

class CatRepo(private val api: CatAPI) {

    suspend fun getCatFact(): CatFact? {

        return try {
            val response = api.getCatFact()

            if (response.isSuccessful) {
                response.body()
            } else {
                // TODO: A proper logging should be done here, maybe using
                //  Crashlytics, through a Logger module
                Timber.e("API call failed: ${response.errorBody()}");
                null
            }

        } catch (e: Exception) {
            Timber.e("Exception: $e");
            null
        }
    }
}