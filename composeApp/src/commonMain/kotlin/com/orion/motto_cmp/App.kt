package com.orion.motto_cmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.orion.motto_cmp.common.layout.MainLayout
import com.orion.motto_cmp.features.home.screen.HomeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        MainLayout(
            content = { HomeScreen() }
        )
    }
}