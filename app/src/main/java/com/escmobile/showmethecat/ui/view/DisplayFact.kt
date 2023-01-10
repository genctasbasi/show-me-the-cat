package com.escmobile.showmethecat.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.escmobile.showmethecat.data.CAT_IMAGES_URL
import com.escmobile.showmethecat.ui.viewModule.CatViewModel

@Composable
fun DisplayFact(catViewModel: CatViewModel) {

    val fact by catViewModel.catFact.observeAsState()

    Column( // container
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        fact?.let { catFact ->

            AsyncImage(
                model = CAT_IMAGES_URL,
                contentDescription = "Hopefully a cute cat photo"
            )

            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = catFact.fact)

                Text(text = "As a useless info, the length of this fact is: ${catFact.length.toString()}")
            }
        }
    }
}