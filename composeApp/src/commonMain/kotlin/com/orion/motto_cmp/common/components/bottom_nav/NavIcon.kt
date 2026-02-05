package com.orion.motto_cmp.common.components.bottom_nav

import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.DrawableResource

sealed class NavIcon{
    data class Vector(val icon: ImageVector) : NavIcon()
    data class Png(val image: DrawableResource) : NavIcon()
}
