package com.example.bookstreak.ui.dashboard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookstreak.theme.BookStreakTheme

@Composable
fun DashboardScreen(){


    Text("Apps should not have accounts information")
}

@Preview
@Composable
fun PreviewDashboardScreen(){
    BookStreakTheme {
        DashboardScreen()
    }
}