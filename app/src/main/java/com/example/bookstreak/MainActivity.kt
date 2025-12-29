package com.example.bookstreak

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.bookstreak.auth.AuthViewModel
import com.example.bookstreak.navigation.BookStreakApp
import com.example.bookstreak.theme.BookStreakTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookStreakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    BookStreakApp(
                        modifier = Modifier.padding(innerPadding),
                        authViewModel
                    )
                }
            }
        }
    }
}


