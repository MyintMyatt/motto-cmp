package com.orion.motto_cmp.common.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowSize { Compact, Medium, Expanded }

@Composable
fun rememberWindowSize(
    screenWidth: Dp
): WindowSize {
    return when {
        screenWidth < 600.dp -> WindowSize.Compact
        screenWidth < 840.dp -> WindowSize.Medium
        else -> WindowSize.Expanded
    }
}
