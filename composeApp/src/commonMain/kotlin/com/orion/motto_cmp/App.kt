package com.orion.motto_cmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.orion.motto_cmp.navigation.AppNavGraph
import com.orion.motto_cmp.ui.MottoTheme

@Composable
@Preview
fun App() {
    val navController = rememberNavController();

    MottoTheme {
        AppNavGraph(
            navController
        )
    }
}