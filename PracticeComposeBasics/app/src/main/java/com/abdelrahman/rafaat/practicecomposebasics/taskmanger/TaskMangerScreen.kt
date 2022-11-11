package com.abdelrahman.rafaat.practicecomposebasics.taskmanger


import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.rafaat.practicecomposebasics.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskMangerScreenPreview() {
    TaskMangerScreen()
}

@Composable
fun TaskMangerScreen() {
    val taskManger = TaskManger(
        painterResource(id = R.drawable.ic_task_completed),
        stringResource(id = R.string.task_title),
        stringResource(R.string.task_description)
    )
    TaskMangerItm(taskManger)

}

@Composable
fun TaskMangerItm(taskManger: TaskManger) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = taskManger.image
        Image(painter = image, contentDescription = "Task Manger Image")
        Text(
            text = taskManger.title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = taskManger.description,
            fontSize = 16.sp
        )
    }
}

