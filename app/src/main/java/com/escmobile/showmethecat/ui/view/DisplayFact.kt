package com.escmobile.showmethecat.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.escmobile.showmethecat.data.CAT_IMAGES_URL
import com.escmobile.showmethecat.ui.viewModule.CatViewModel
import com.escmobile.showmethecat.R
import com.escmobile.showmethecat.data.model.CatFact
import com.escmobile.showmethecat.ui.viewModule.CatViewState

@Composable
fun DisplayFact(catViewModel: CatViewModel) {

    val fact by catViewModel.catFactResult.observeAsState(initial = CatViewState.NotSet)

    when (fact) {
        is CatViewState.Fact -> RenderFact((fact as CatViewState.Fact).result)
        is CatViewState.InProgress -> CircularProgressIndicator()
        is CatViewState.NotSet -> { // here for the sake of completeness - no need to do anything
        }
        is CatViewState.Error -> {
            Text(
                color = Color.Red, text = stringResource(id = R.string.network_error)
            )
        }
    }
}

@Composable
private fun RenderFact(fact: CatFact) {
    Column( // container
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            placeholder = painterResource(R.drawable.cat_placeholder),
            model = CAT_IMAGES_URL + fact.length,
            contentDescription = "Hopefully a cute cat photo"
        )

        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = fact.fact)

            Text(
                modifier = Modifier.padding(top = 20.dp),
                fontStyle = FontStyle.Italic,
                text = "As a useless info, the length of this fact is: ${fact.length}"
            )
        }
    }
}