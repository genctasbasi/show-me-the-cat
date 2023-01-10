package com.escmobile.showmethecat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.escmobile.showmethecat.ui.theme.ShowMeTheCatTheme
import com.escmobile.showmethecat.ui.view.DisplayFact
import com.escmobile.showmethecat.ui.view.GetFact
import com.escmobile.showmethecat.ui.viewModule.CatViewModel
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val catViewModel : CatViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowMeTheCatTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DisplayFact(catViewModel)
                    GetFact(::onGetFactButtonClick)
                }
            }
        }
    }

    private fun onGetFactButtonClick(){
        catViewModel.getCatFact()
    }
}