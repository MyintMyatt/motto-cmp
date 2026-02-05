package com.orion.motto_cmp.ui

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import mottocmp.composeapp.generated.resources.Res
import mottocmp.composeapp.generated.resources.aux_mono
import org.jetbrains.compose.resources.Font

@Composable
fun GetAuxMono() = FontFamily(
    Font(Res.font.aux_mono, weight = FontWeight.Bold),
)

@Composable
fun DefaultTypography(): Typography {
    return Typography(
        bodyLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp
        )
    )
}