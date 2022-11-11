package com.abdelrahman.rafaat.practicecomposebasics.article


import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.rafaat.practicecomposebasics.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantScreenPreview() {
    ArticleScreen()
}

@Composable
fun ArticleScreen() {
    val article = Article(
        painterResource(id = R.drawable.ic_article_background),
        stringResource(id = R.string.article_title),
        stringResource(id = R.string.article_description),
        stringResource(id = R.string.article_content)
    )
    ArticleItm(article)
}

@Composable
fun ArticleItm(article: Article) {
    Column {
        Image(painter = article.image, contentDescription = "Article Image")
        Text(
            text = article.title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = article.description,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = article.content,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

