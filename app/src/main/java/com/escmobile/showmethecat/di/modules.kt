package com.escmobile.showmethecat.di

import com.escmobile.showmethecat.data.BASE_URL
import com.escmobile.showmethecat.data.CatAPI
import com.escmobile.showmethecat.data.CatRepo
import com.escmobile.showmethecat.ui.viewModule.CatViewModel
import org.koin.androidx.compose.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single { CatViewModel(get()) }
    single { CatRepo(get()) }
}

val apiModule = module {

    val builder =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    val catAPI = builder.create(CatAPI::class.java)

    single { catAPI }
}