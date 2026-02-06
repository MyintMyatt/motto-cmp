package com.orion.motto_cmp.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.orion.motto_cmp.common.layout.MainLayout
import com.orion.motto_cmp.features.home.screen.HomeScreen
import com.orion.motto_cmp.features.reading.screens.ReadingScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController, startDestination = Screen.Home
    ) {
        composable<Screen.Home>(enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right, tween(500)
            )
        }, exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left, tween(400)
            )
        }) {
            MainLayout(
                navController = navController, content = {
                    HomeScreen(navController)
                })
        }
        composable<Screen.Reading> {
            MainLayout(
                navController = navController, content = {
                    ReadingScreen()
                })
        }
        composable<Screen.Kanji> {
            MainLayout(
                navController = navController, content = {
                    ReadingScreen()
                })
        }
        composable<Screen.Grammar> {
            MainLayout(
                navController = navController, content = {
                    ReadingScreen()
                })
        }
        composable<Screen.Listening> {
            MainLayout(
                navController = navController, content = {
                    ReadingScreen()
                })
        }
        composable<Screen.Vocabulary> {
            MainLayout(
                navController = navController, content = {
                    ReadingScreen()
                })
        }
        composable<Screen.Setting> {
            MainLayout(
                navController = navController, content = {
                    ReadingScreen()
                })
        }
    }
}