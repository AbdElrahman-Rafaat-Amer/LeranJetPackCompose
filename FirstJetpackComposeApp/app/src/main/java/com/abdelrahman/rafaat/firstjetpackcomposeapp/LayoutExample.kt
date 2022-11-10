package com.abdelrahman.rafaat.firstjetpackcomposeapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MyBoxLayout() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .background(Color.Black)
            .padding(20.dp)
            .clip(RoundedCornerShape(size = 10.dp))
            .background(colorResource(id = R.color.orange))
    ) {
        Text(
            text = stringResource(id = R.string.first_name),
            Modifier
                .align(Alignment.TopStart)
                .padding(30.dp, 30.dp, 0.dp, 0.dp),
            color = Color.Red,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = stringResource(id = R.string.second_name),
            Modifier.align(Alignment.Center), color = Color.White,
            fontSize = 30.sp, fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Monospace
        )
        Text(
            text = stringResource(id = R.string.third_name),
            Modifier
                .align(Alignment.BottomEnd)
                .padding(0.dp, 0.dp, 30.dp, 30.dp),
            color = Color.Black,
            fontSize = 30.sp,
            textDecoration = TextDecoration.Underline,
            fontFamily = FontFamily.SansSerif
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MyLayouts() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        MyTextField()
        MyButton()
        Row(verticalAlignment = Alignment.CenterVertically) {
            MyText()
            MyImage()
        }
    }
}