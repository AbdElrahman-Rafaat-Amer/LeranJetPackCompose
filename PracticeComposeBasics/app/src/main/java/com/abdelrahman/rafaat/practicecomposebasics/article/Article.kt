package com.abdelrahman.rafaat.practicecomposebasics.article

import androidx.compose.ui.graphics.painter.Painter

data class Article(
    var image: Painter,
    var title: String,
    var description: String,
    var content: String
)

