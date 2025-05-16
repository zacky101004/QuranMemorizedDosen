package com.example.quranmemorizationdosen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quranmemorizationdosen.ui.screens.DashboardScreen
import com.example.quranmemorizationdosen.ui.screens.LoginScreen
import com.example.quranmemorizationdosen.ui.theme.QuranMemorizationDosenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuranMemorizationDosenTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") {
                            LoginScreen(onLoginSuccess = { username ->
                                navController.navigate("dashboard/$username") {
                                    popUpTo("login") { inclusive = true }
                                }
                            })
                        }
                        composable("dashboard/{username}") { backStackEntry ->
                            val username = backStackEntry.arguments?.getString("username") ?: ""
                            DashboardScreen(
                                username = username,
                                onLogout = {
                                    navController.navigate("login") {
                                        popUpTo("dashboard/$username") { inclusive = true }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}