package com.example.bookstreak.ui.componenets

import android.icu.text.CaseMap
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BookCard() {
    Card {
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
            BookInfoSection()
            ProgressRing()
        }
    }
}

@Composable
fun ProgressRing() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(140.dp)
    ) {
        CircularProgressIndicator(
            progress = { 0.5f },
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 10.dp,
            trackColor = MaterialTheme.colorScheme.outlineVariant,
            strokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap,
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "50%",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = "165  left",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Composable
fun BookInfoSection() {
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        // title
        Text(text = "The Hobbit", style = MaterialTheme.typography.titleMedium)
        // author
        Text(text = "J.R.R. Tolkien", style = MaterialTheme.typography.bodyLarge)
        // page
        Text(text = "135 of 300 pages", style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview
@Composable
fun PreviewBookCard() {
    BookCard()
}