package com.abdelrahman.rafaat.practicecomposebasics.quadrant


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantScreenPreview() {
    QuadrantScreen()
}

@Composable
fun QuadrantScreen() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            QuadrantItm(
                listOfQuadrants[0],
                modifier = Modifier.weight(1f)
            )
            QuadrantItm(
                listOfQuadrants[1],
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            QuadrantItm(
                listOfQuadrants[2],
                modifier = Modifier.weight(1f)
            )
            QuadrantItm(
                listOfQuadrants[3],
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantItm(quadrant: Quadrant, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(quadrant.backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = quadrant.title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = quadrant.description,
            textAlign = TextAlign.Justify
        )
    }
}

