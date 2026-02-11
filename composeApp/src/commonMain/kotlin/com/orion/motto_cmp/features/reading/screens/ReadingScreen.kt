package com.orion.motto_cmp.features.reading.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.orion.motto_cmp.common.components.app.TextHeadLine
import com.orion.motto_cmp.common.util.rememberWindowSize
import com.orion.motto_cmp.features.reading.components.FabMenu
import com.orion.motto_cmp.navigation.Screen

@Composable
fun ReadingScreen(
    navController: NavController
) {

    var screenSize by remember { mutableStateOf(IntSize.Zero) }
    var windowSize = rememberWindowSize(with(LocalDensity.current) { screenSize.width.toDp() })


    Box (
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        navController.navigate(Screen.Home)
                    }, colors = IconButtonDefaults.iconButtonColors(
                        MaterialTheme.colorScheme.primary.copy(
                            alpha = .05f
                        )
                    )
                ) {
                    Icon(
                        Icons.Default.ChevronLeft, contentDescription = "back icon"
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                TextHeadLine("Reading Page")
            }
        }
        // Place the FAB manually or pass it to MainLayout
        FabMenu(
            windowSize = windowSize,
            modifier = Modifier
                .align(Alignment.BottomEnd)
//                .padding(/*bottom = 80.dp,*/ end = 16.dp)
        )
    }
}