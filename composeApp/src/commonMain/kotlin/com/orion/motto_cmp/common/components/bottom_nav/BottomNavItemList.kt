package com.orion.motto_cmp.common.components.bottom_nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesomeMosaic
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import mottocmp.composeapp.generated.resources.Res
import mottocmp.composeapp.generated.resources.hiragana_a


val bottomNavItems = listOf(
    BottomNavItem(
        route = "home",
        label = "Home",
        icon = NavIcon.Vector(Icons.Rounded.AutoAwesomeMosaic),
    ),
    BottomNavItem(
        route = "",
        label = "Language",
        icon = NavIcon.Png(Res.drawable.hiragana_a)
    ),
    BottomNavItem(
        route = "",
        label = "Search",
        icon = NavIcon.Vector(Icons.Rounded.Search)
    ),
    BottomNavItem(
        route = "",
        label = "Settings",
        icon = NavIcon.Vector(Icons.Rounded.Settings)
    )
)
