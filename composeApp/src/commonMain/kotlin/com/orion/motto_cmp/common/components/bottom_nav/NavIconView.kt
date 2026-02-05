package com.orion.motto_cmp.common.components.bottom_nav

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.painterResource

@Composable
fun NavIconView(
    icon: NavIcon,
    contentDescription: String,
    tint: Color,
    modifier: Modifier
) {
    when (icon) {
        is NavIcon.Vector -> {
            Icon(
                imageVector = icon.icon,
                contentDescription = contentDescription,
                tint = tint,
                modifier = modifier
            )
        }
        is NavIcon.Png -> {
            Icon(
                painter = painterResource(icon.image),
                contentDescription = contentDescription,
                tint = tint,
                modifier = modifier
            )
        }
    }
}