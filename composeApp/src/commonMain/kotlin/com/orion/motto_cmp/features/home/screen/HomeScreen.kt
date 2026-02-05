package com.orion.motto_cmp.features.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.orion.motto_cmp.ui.GetAuxMono

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Hello", fontFamily = GetAuxMono(), textAlign = TextAlign.Center)
    }
}