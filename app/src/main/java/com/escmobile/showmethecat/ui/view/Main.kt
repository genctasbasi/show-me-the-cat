package com.escmobile.showmethecat.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.escmobile.showmethecat.ui.viewModule.CatViewModel

@Composable
fun Main(catViewModel: CatViewModel, onGetFactButtonClick: () -> Unit) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally

    ) {
        DisplayFact(catViewModel)
        GetFact(onGetFactButtonClick)
    }
}