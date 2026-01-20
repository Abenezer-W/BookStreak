package com.example.bookstreak.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bookstreak.R
import com.example.bookstreak.theme.BookStreakTheme
import com.example.bookstreak.ui.dashboard.DashboardScreen
import com.example.bookstreak.ui.LibraryScreen
import com.example.bookstreak.ui.StatsScreen

enum class BookStreakScreens {
    DashBoard,
    Library,
    Stats,
}


@Composable
fun BookStreakApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = BookStreakScreens.valueOf(
        backStackEntry?.destination?.route ?: BookStreakScreens.DashBoard.name
    )
    Scaffold(
        bottomBar = {
            BottomAppBar {
                BottomBarButtons(onFocusScreen = currentScreen, onButtonClick = {
                    navController.navigate(it.name)
                }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = currentScreen.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = BookStreakScreens.DashBoard.name) {
                DashboardScreen()
            }

            composable(route = BookStreakScreens.Library.name) {
                LibraryScreen()
            }

            composable(route = BookStreakScreens.Stats.name) {
                StatsScreen()
            }

        }
    }
}


@Composable
fun BottomBarButtons(
    onFocusScreen: BookStreakScreens,
    modifier: Modifier = Modifier,
    onButtonClick: (BookStreakScreens) -> Unit = {},
) {
    NavigationBar {
        NavigationBarItem(
            selected = BookStreakScreens.DashBoard == onFocusScreen,
            onClick = { onButtonClick(BookStreakScreens.DashBoard) },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.home),
                    contentDescription = "Home"
                )
            },
            label = { Text("home") }
        )

        NavigationBarItem(
            selected = onFocusScreen == BookStreakScreens.Library,
            onClick = { onButtonClick(BookStreakScreens.Library) },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.library),
                    contentDescription = "Library"
                )
            },
            label = { Text("Library") }
        )

        NavigationBarItem(
            selected = onFocusScreen == BookStreakScreens.Stats,
            onClick = { onButtonClick(BookStreakScreens.Stats) },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.bar_chart),
                    contentDescription = "Stats"
                )
            },
            label = { Text("Stats") }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewBottomBar() {
    BookStreakTheme {
        BottomBarButtons(onFocusScreen =  BookStreakScreens.DashBoard)
    }
}

