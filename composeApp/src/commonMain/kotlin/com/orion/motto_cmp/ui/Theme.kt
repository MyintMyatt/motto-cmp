package com.orion.motto_cmp.ui

import androidx.compose.animation.core.ExperimentalAnimationSpecApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    background = DarkBackground,
    surface = DarkSurface,
    onBackground = Color.White, // Add this
    onSurface = Color.White,    // Add this
    secondary = logoColor,
    tertiary = Pink80,
    outline = DarkOutline,
)

private val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    background = LightBackground,
    surface = LightSurface,
    onBackground = Color(0xFF1C1B1F), // Add this (Dark Grey/Black)
    onSurface = Color(0xFF1C1B1F),    // Add this
    secondary = logoColor,
    tertiary = Pink40,
    outline = LightOutline
)


@OptIn(ExperimentalAnimationSpecApi::class)
@Composable
fun MottoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
//    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {

    //for theme switch
//    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme


    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = DefaultTypography(),
        content = content
    )
}