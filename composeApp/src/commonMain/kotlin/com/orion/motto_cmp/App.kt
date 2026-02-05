package com.orion.motto_cmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.orion.motto_cmp.common.layout.MainLayout
import com.orion.motto_cmp.features.home.screen.HomeScreen
import com.orion.motto_cmp.ui.MottoTheme

@Composable
@Preview
fun App() {
    MottoTheme {
        MainLayout(
            content = {
                HomeScreen()
            }
        )
    }
}