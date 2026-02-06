package com.orion.motto_cmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.orion.motto_cmp.navigation.AppNavGraph
import com.orion.motto_cmp.ui.MottoTheme

@Composable
@Preview
fun App() {
    val navController = rememberNavController();
    var isDark by remember { mutableStateOf(false) }

    MottoTheme (darkTheme =  isDark){
        AppNavGraph(
            navController = navController,
            isDarkTheme = isDark,
            onThemeToggle = { isDark = !isDark }
        )
    }
}