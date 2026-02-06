package com.orion.motto_cmp.common.components.bottom_nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesomeMosaic
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import com.orion.motto_cmp.navigation.Screen
import mottocmp.composeapp.generated.resources.Res
import mottocmp.composeapp.generated.resources.hiragana_a


val bottomNavItems = listOf(
    BottomNavItem(
        route = Screen.Home,
        label = "Home",
        icon = NavIcon.Vector(Icons.Rounded.AutoAwesomeMosaic),
    ),
    BottomNavItem(
        route = Screen.Kanji,
        label = "Language",
        icon = NavIcon.Png(Res.drawable.hiragana_a)
    ),
    BottomNavItem(
        route = Screen.Home,
        label = "Search",
        icon = NavIcon.Vector(Icons.Rounded.Search)
    ),
    BottomNavItem(
        route = Screen.Setting,
        label = "Settings",
        icon = NavIcon.Vector(Icons.Rounded.Settings)
    )
)
