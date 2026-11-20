package com.amcalculator.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val CathayJade = Color(0xFF006564)
val CathayDarkJade = Color(0xFF004A49)
val CathayDeepJade = Color(0xFF003332)
val CathayMint = Color(0xFFD6ECEB)
val CathayGold = Color(0xFFC4A46B)
val CathayGoldDark = Color(0xFF8C6E3B)
val CathayGoldSoft = Color(0xFFF7F0E2)
val WarningAmber = Color(0xFFB45309)
val WarningAmberBg = Color(0xFFFEF3C7)
val SuccessGreen = Color(0xFF047857)
val SuccessGreenBg = Color(0xFFD1FAE5)

private val LightColors = lightColorScheme(
    primary = CathayJade,
    onPrimary = Color.White,
    primaryContainer = CathayMint,
    onPrimaryContainer = CathayDeepJade,
    secondary = CathayGoldDark,
    onSecondary = Color.White,
    secondaryContainer = CathayGoldSoft,
    onSecondaryContainer = Color(0xFF3E2D12),
    background = Color(0xFFF4F7F6),
    onBackground = Color(0xFF101C1C),
    surface = Color.White,
    onSurface = Color(0xFF101C1C),
    surfaceVariant = Color(0xFFE7EFEF),
    onSurfaceVariant = Color(0xFF3F4E4E),
    outline = Color(0xFFB8C7C7)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF4DB6AC),
    onPrimary = Color(0xFF003736),
    primaryContainer = CathayDarkJade,
    onPrimaryContainer = CathayMint,
    secondary = CathayGold,
    onSecondary = Color(0xFF2E2009),
    secondaryContainer = Color(0xFF4A3819),
    onSecondaryContainer = CathayGoldSoft,
    background = Color(0xFF0C1414),
    onBackground = Color(0xFFE5EFEF),
    surface = Color(0xFF132020),
    onSurface = Color(0xFFE5EFEF),
    surfaceVariant = Color(0xFF1D2E2E),
    onSurfaceVariant = Color(0xFFAABBBB),
    outline = Color(0xFF3A4E4E)
)

@Composable
fun AMCalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        content = content
    )
}
