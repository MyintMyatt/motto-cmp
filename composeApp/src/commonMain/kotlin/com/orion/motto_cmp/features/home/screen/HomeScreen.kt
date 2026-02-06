package com.orion.motto_cmp.features.home.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.orion.motto_cmp.common.components.app.AppLogo
import com.orion.motto_cmp.common.components.app.AppName
import com.orion.motto_cmp.common.components.app.TextHeadLine
import com.orion.motto_cmp.common.util.WindowSize
import com.orion.motto_cmp.common.util.rememberWindowSize
import com.orion.motto_cmp.features.home.components.LearningModuleCard
import com.orion.motto_cmp.features.home.data.HomePageModules

@Composable
fun HomeScreen(
    navController: NavHostController,
) {
    var screenSize by remember { mutableStateOf(IntSize.Zero) }
    var windowSize = rememberWindowSize(with(LocalDensity.current) { screenSize.width.toDp() })
    Box(modifier = Modifier.onGloballyPositioned { coordinates -> screenSize = coordinates.size }
        .fillMaxSize()) {
        val scrollState = rememberLazyListState()
        when (windowSize) {
            // for mobile size
            WindowSize.Compact -> {
                LazyColumn(
                    state = scrollState
                ) {
                    item {
                        AnimatedVisibility(
                            visible = true,
                            enter = fadeIn(tween(500)) + slideInVertically(initialOffsetY = { 40 }),
                            exit = fadeOut()
                        ) {
                            Column {
                                Spacer(modifier = Modifier.height(30.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    TextHeadLine("Welcome to ")
                                    AppLogo()
                                    Spacer(modifier = Modifier.width(10.dp))
                                    AppName(
                                        style = MaterialTheme.typography.headlineSmall,
                                    )
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    "Ready to Start your journey? Pick a module below to master your fluency." , color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(40.dp))
                            }
                        }
                    }

                    item {
                        TextHeadLine("Learning Modules")
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    itemsIndexed(
                        items = HomePageModules,
                        key = { _, module -> module.title } // Keeps scroll state synced
                    ) { index, module ->
                        LearningModuleCard(
                            title = module.title,
                            desc = module.desc,
                            iconText = module.icon,
                            iconColor = module.color,
                            onClick = {
                                navController.navigate(module.route)
                            })
                    }
                }
            }

            // for desktop
            WindowSize.Medium, WindowSize.Expanded -> {
                Column {
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        TextHeadLine("Welcome to ")
                        AppLogo()
                        Spacer(modifier = Modifier.width(10.dp))
                        AppName(
                            style = MaterialTheme.typography.headlineSmall,
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "Ready to Start your journey? Pick a module below to master your fluency.", color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    TextHeadLine("Learning Modules")
                    Spacer(modifier = Modifier.height(10.dp))
                    LazyVerticalGrid(
                        columns = if (windowSize == WindowSize.Expanded) GridCells.Fixed(3) else GridCells.Adaptive(minSize = 350.dp),
//                        columns = GridCells.Fixed(3),
                        contentPadding = PaddingValues(10.dp),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        itemsIndexed(
                            items = HomePageModules,
                            key = { _, module -> module.title } // Keeps scroll state synced
                        ) { index, module ->
                            LearningModuleCard(
                                title = module.title,
                                desc = module.desc,
                                iconText = module.icon,
                                iconColor = module.color,
                                onClick = {
                                    navController.navigate(module.route)
                                })
                        }

                    }
                }
            }
        }
    }
}