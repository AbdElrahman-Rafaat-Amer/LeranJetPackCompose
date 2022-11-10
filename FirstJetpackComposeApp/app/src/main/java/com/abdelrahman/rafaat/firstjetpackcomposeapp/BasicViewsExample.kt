package com.abdelrahman.rafaat.firstjetpackcomposeapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MyText() {
    Text(
        text = "Welcome",
        style = TextStyle(
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            background = Color.Gray,
            textAlign = TextAlign.Center
        ),
        maxLines = 2
    )
}

@Preview(showBackground = true)
@Composable
fun MyButton() {
    var buttonState by remember { mutableStateOf(true) }
    Log.i("MyButtonState", "MyButton: buttonState------> $buttonState")
    Button(
        onClick = { buttonState = !buttonState },
        enabled = buttonState,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            disabledBackgroundColor = Color.Gray,
            contentColor = Color.White
        )
    ) {
        Text(text = if (buttonState) "Click Me!!" else "Button Disabled")
    }
}

@Preview(showBackground = true)
@Composable
fun MyTextField() {
    var welcomeMessage by remember { mutableStateOf("enter your name") }
    TextField(value = welcomeMessage,
        onValueChange = {
            welcomeMessage = it
        },
        label = { Text(text = "User Name") })
}

@Preview(showBackground = true)
@Composable
fun MyImage() {
    Image(painter = painterResource(id = R.drawable.ic_icon), contentDescription = "Icon")
}
