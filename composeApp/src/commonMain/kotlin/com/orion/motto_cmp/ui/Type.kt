package com.orion.motto_cmp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import mottocmp.composeapp.generated.resources.Res
import mottocmp.composeapp.generated.resources.aux_mono
import org.jetbrains.compose.resources.Font

@Composable
fun GetAuxMono() = FontFamily(
    Font(Res.font.aux_mono, weight = FontWeight.Bold),
)