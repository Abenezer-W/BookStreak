package com.example.bookstreak.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bookstreak.auth.AuthViewModel
import com.example.bookstreak.auth.SignUpScreen

enum class BookStreakScreens {
    SignUp,
    Login,
    DashBoard,
    Progress,
    Feedback,
    AddBook,
    Commitment,
    Plan
}


@Composable
fun BookStreakApp(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = BookStreakScreens.valueOf(
        backStackEntry?.destination?.route ?: BookStreakScreens.SignUp.name
    )
    Log.i("ABE", "currentScreen $currentScreen")
    NavHost(
        navController = navController,
        startDestination = currentScreen.name,
        modifier = modifier
    ) {
        composable(route = BookStreakScreens.SignUp.name) {
            SignUpScreen()
        }
    }
}