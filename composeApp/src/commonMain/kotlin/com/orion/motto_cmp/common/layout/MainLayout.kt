package com.orion.motto_cmp.common.layout

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.orion.motto_cmp.common.components.app.AppBar
import com.orion.motto_cmp.common.components.bottom_nav.BottomNav
import com.orion.motto_cmp.common.util.WindowSize
import com.orion.motto_cmp.common.util.rememberWindowSize
import com.orion.motto_cmp.ui.MottoTheme

@Composable
fun MainLayout(
    navController: NavHostController,
    isShowAppBar: Boolean = true,
    isShowBottomNav: Boolean = true,
    content: @Composable () -> Unit,
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit,
) {

    // Stores where the user tapped
    var revealCenter by remember { mutableStateOf<Offset?>(null) }

    // This controls the radius animation
    // 3000f is usually enough to cover any phone screen size
    val animatedRadius by animateFloatAsState(
        targetValue = if (revealCenter != null) 3000f else 0f,
        animationSpec = tween(durationMillis = 700, easing = FastOutSlowInEasing),
        finishedListener = {
            if (revealCenter != null) {
                // IMPORTANT: Only toggle the real global theme when animation finishes
                onThemeToggle()
                revealCenter = null
            }
        },
        label = "RevealAnimation"
    )

    var screenSize by remember { mutableStateOf(IntSize.Zero) }
    val windowSize = rememberWindowSize(with(LocalDensity.current) { screenSize.width.toDp() })

    val horizontalPadding = when (windowSize) {
        WindowSize.Compact -> 16.dp  // Standard mobile margin
        WindowSize.Medium -> 32.dp
        WindowSize.Expanded -> 64.dp // Large desktop margin
    }
    Box(
        modifier = Modifier
            .onGloballyPositioned { coordinates -> screenSize = coordinates.size }
            .fillMaxSize()
            .padding(0.dp)
    ) {

        //BASE LAYER
        MottoTheme(darkTheme = isDarkTheme) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(horizontal = horizontalPadding)
//                    .padding(horizontal = if (windowSize == WindowSize.Compact) 0.dp else 15.dp)
                    .padding(top = 10.dp)
                    .safeContentPadding()
            ) {
                if (isShowAppBar){
                    AppBar(
                        isDarkTheme = isDarkTheme,
                        onThemeToggle = { offset ->
                            // Trigger the animation by setting the center point
                            revealCenter = offset
                        },
                        animateIcon = revealCenter == null,
                        isToggleEnabled = revealCenter == null
                    )
                }
                content()
                Spacer(modifier = Modifier.weight(1f))
            }
            if (isShowBottomNav){
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 10.dp)
                ) {
                    BottomNav(navController = navController)
                }
            }
        }

        // OVERLAY LAYER
        if (revealCenter != null) {
            MottoTheme(darkTheme = !isDarkTheme) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleClip(revealCenter!!, animatedRadius))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                            .padding(horizontal = if (windowSize == WindowSize.Compact) 0.dp else 15.dp)
                            .padding(top = 10.dp)
                            .safeContentPadding()
                    ) {
                        if(isShowAppBar) {
                            AppBar(
                                isDarkTheme = !isDarkTheme,
                                animateIcon = true,
                                isToggleEnabled = true,
                                onThemeToggle = {}
                            )
                        }
                        content()
                        Spacer(modifier = Modifier.weight(1f))
                    }

                    if (isShowBottomNav){
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 10.dp)
                        ) {
                            BottomNav(navController = navController)
                        }
                    }
                }
            }
        }

    }
}

class CircleClip(private val center: Offset, private val radius: Float) : Shape {
    override fun createOutline(
        size: androidx.compose.ui.geometry.Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            addOval(Rect(center, radius))
        }
        return Outline.Generic(path)
    }
}