package com.abdelrahman.rafaat.practicecomposebasics.taskmanger

import androidx.compose.ui.graphics.painter.Painter

data class TaskManger(
    var image: Painter,
    var title: String,
    var description: String
)

