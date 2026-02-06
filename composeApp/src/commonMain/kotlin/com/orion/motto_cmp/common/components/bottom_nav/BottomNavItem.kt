package com.orion.motto_cmp.common.components.bottom_nav

import com.orion.motto_cmp.navigation.Screen

data class BottomNavItem (
    val route: Screen,
    val label: String,
    val icon: NavIcon,
)