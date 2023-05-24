package com.abdelrahman.rafaat.firstjetpackcomposeapp.gym

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abdelrahman.rafaat.firstjetpackcomposeapp.ui.theme.Purple200

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GymScreen() {
    /*
//      Column Iteration -->
//       not best way to show list act as (ListView in XML)
    Column(Modifier.verticalScroll(rememberScrollState())) {
        listOfGyms.forEach {
            GymItm(it)
        }
    }

//     Lazy Column -->
//    best way to show list act as (RecyclerView in XML)
//     By this way will show The GymItem 3 times because i pass number 3
    LazyColumn {
         item(3) {
             GymItm(gym = Gym("Test", "fake Address"))
         }
     }
     */
    val viewModel: GymViewModel = viewModel()


    /* //rememberSaveable to save state when configuration changed
     var gymState by rememberSaveable { mutableStateOf(viewModel.gymState) }*/
    LazyColumn {
        items(viewModel.gymState) { gym ->
            GymItm(gym) { gymID ->
                viewModel.addToFavorite(gymID)
            }
        }
    }

}

@Composable
fun GymItm(gym: Gym, onClick: (Int) -> Unit) {

    val favoriteIcon = if (gym.isFavorite) {
        Icons.Filled.Favorite
    } else {
        Icons.Filled.FavoriteBorder
    }

    Card(elevation = 7.dp, modifier = Modifier.padding(7.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(7.dp)
        ) {
            GymIcon(Icons.Filled.Place, "Gym Place", Modifier.weight(0.15f))
            GymDetails(gym, Modifier.weight(0.70f))
            GymIcon(favoriteIcon, "favorite Icon", Modifier.weight(0.15f)) {
                onClick(gym.id)
            }
        }

    }

}


@Composable
fun GymDetails(gym: Gym, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = gym.name,
            style = MaterialTheme.typography.h6,
            color = Purple200
        )
        //To reduce opacity
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(
                text = gym.location,
                style = MaterialTheme.typography.body2
            )
        }

    }
}

@Composable
fun GymIcon(
    icon: ImageVector,
    contentDescription: String,
    modifier: Modifier,
    onClick: () -> Unit = {}
) {

    Image(
        imageVector = icon,
        contentDescription = contentDescription,
        colorFilter = ColorFilter.tint(Color.Gray),
        modifier = modifier.clickable {
            onClick()
        }
    )
}