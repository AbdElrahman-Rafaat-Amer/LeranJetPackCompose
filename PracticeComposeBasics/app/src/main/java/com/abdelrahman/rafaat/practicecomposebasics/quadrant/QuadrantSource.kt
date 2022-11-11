package com.abdelrahman.rafaat.practicecomposebasics.quadrant

import androidx.compose.ui.graphics.Color


val listOfQuadrants = listOf(
    Quadrant(
        "Text composable",
        "Displays text and follows Material Design guidelines.",
        Color.Green
    ),
    Quadrant(
        "Image composable",
        "Creates a composable that lays out and draws a given Painter class object.",
        Color.Yellow
    ),
    Quadrant(
        "Row composable",
        "A layout composable that places its children in a horizontal sequence.",
        Color.Cyan
    ),
    Quadrant(
        "Column composable",
        "A layout composable that places its children in a vertical sequence.",
        Color.LightGray
    )
)