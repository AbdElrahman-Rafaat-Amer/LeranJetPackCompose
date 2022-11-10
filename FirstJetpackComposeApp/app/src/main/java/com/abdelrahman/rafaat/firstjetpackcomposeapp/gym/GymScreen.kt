package com.abdelrahman.rafaat.firstjetpackcomposeapp.gym

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.rafaat.firstjetpackcomposeapp.ui.theme.FirstJetpackComposeAppTheme
import com.abdelrahman.rafaat.firstjetpackcomposeapp.ui.theme.Purple200

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GymScreen() {
    /*  Column Iteration -->
       not best way to show list act as (ListView in XML)
    Column(Modifier.verticalScroll(rememberScrollState())) {
        listOfGyms.forEach {
            GymItm(it)
        }
    }
    */

    /* Lazy Column -->
    best way to show list act as (RecyclerView in XML)*/
    /* By this way will show The GymItem 3 times because i pass number 3
    LazyColumn() {
         item(3) {
             GymItm(gym = Gym("Test", "fake Address"))
         }
     }*/
    LazyColumn {
        items(listOfGyms) {
            GymItm(it)
        }
    }

}

@Composable
fun GymItm(gym: Gym) {
    Card(elevation = 7.dp, modifier = Modifier.padding(7.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(7.dp)
        ) {
            GymIcon(Icons.Filled.Place, Modifier.weight(0.15f))
            GymDetails(gym, Modifier.weight(0.85f))
        }

    }

}

@Composable
fun GymIcon(place: ImageVector, modifier: Modifier) {
    Image(
        imageVector = place, contentDescription = "Location",
        modifier = modifier, colorFilter = ColorFilter.tint(Color.Gray)
    )
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
                text = gym.address,
                style = MaterialTheme.typography.body2
            )
        }

    }
}
