package com.abdelrahman.rafaat.practicecomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.abdelrahman.rafaat.practicecomposebasics.article.ArticleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //  QuadrantScreen()
            //  TaskMangerScreen()
            ArticleScreen()
        }
    }
}

