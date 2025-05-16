package com.example.quranmemorizationdosen.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val IslamicGreen = Color(0xFF1B5E20)
val IslamicGold = Color(0xFFD4AF37)
val IslamicWhite = Color(0xFFF5F5F5)

private val ColorScheme = lightColorScheme(
    primary = IslamicGreen,
    secondary = IslamicGold,
    background = IslamicWhite,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun QuranMemorizationDosenTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ColorScheme,
        typography = Typography,
        content = content
    )
}