package com.abdelrahman.rafaat.firstjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.abdelrahman.rafaat.firstjetpackcomposeapp.gym.GymScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymScreen()
        }
    }


}


