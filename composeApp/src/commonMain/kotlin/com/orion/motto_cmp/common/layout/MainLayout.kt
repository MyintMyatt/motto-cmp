package com.orion.motto_cmp.common.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavHostController
import com.orion.motto_cmp.common.components.app.AppBar
import com.orion.motto_cmp.common.components.bottom_nav.BottomNav
import com.orion.motto_cmp.common.util.WindowSize
import com.orion.motto_cmp.common.util.rememberWindowSize

@Composable
fun MainLayout(
    navController: NavHostController,
    isShowAppBar: Boolean = false,
    content: @Composable () -> Unit,
    isShowBottomNav: Boolean = false,
) {

    var screenSize by remember { mutableStateOf(IntSize.Zero) }
    val windowSize = rememberWindowSize(with(LocalDensity.current) {screenSize.width.toDp()})
    Box(
        modifier = Modifier
            .onGloballyPositioned{ coordinates -> screenSize = coordinates.size}
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = if (windowSize == WindowSize.Compact) 0.dp else 15.dp)
                .padding(top = 10.dp)
                .safeContentPadding()
        ) {
            AppBar()
            content()
            Spacer(modifier = Modifier.weight(1f))
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp)
        ) {
            BottomNav(navController = navController)
        }
    }
}