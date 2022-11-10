package com.abdelrahman.rafaat.firstjetpackcomposeapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScoreSection(score: Int, countScore: () -> Unit) {
    Column {
        Text(text = "Score :$score")
        Button(onClick = countScore) {
            Text(text = "Add points")
        }
    }
}

@Preview(
    showBackground = true, showSystemUi = true,
    name = "Preview1", device = Devices.NEXUS_10
)
@Composable
fun PreviewScoreSection1() {

    var score by remember {
        mutableStateOf(0)
    }
    ScoreSection(score = score, { score += 2 })
}

@Preview(
    showBackground = true, showSystemUi = true,
    name = "Preview1", device = Devices.NEXUS_5
)
@Composable
fun PreviewScoreSection2() {

    ScoreSection(score = 10, {})
}