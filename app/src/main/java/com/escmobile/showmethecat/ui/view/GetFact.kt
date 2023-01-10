package com.escmobile.showmethecat.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GetFact(onGetFactButtonClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Button(
            modifier = Modifier
                .width(200.dp)
                .height(75.dp),
            onClick = onGetFactButtonClick
        ) {
            Text(text = "Show me the cat!")
        }

    }


}