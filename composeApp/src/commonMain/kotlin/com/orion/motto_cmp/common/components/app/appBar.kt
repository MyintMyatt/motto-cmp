package com.orion.motto_cmp.common.components.app

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    isToggleEnabled: Boolean,
    animateIcon: Boolean = true, // Pass this down
    onThemeToggle: (Offset) -> Unit
) {
    val cardShape = RoundedCornerShape(13.dp)

    Card(
        modifier = Modifier
            .shadow(
                elevation = 3.dp, shape = cardShape,
                spotColor = Color.Gray
            )
            .fillMaxWidth(),
        shape = cardShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 10.dp, vertical = 8.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {
            // APP LOGO
            AppLogo()
            // SPACE
            Spacer(modifier = Modifier.widthIn(10.dp))

            // APP NAME
            AppName()

            // SPACE
            Spacer(modifier = Modifier.weight(1.5f))

//            Icon(
//                imageVector = Icons.Rounded.LightMode,
//                contentDescription = "icon",
//            )

            // THEME TOGGLE ICON
            ThemeToggleButton(
                isDarkMode = isDarkTheme,
                onToggle = onThemeToggle,
                animate = animateIcon,
                isToggleEnabled = isToggleEnabled
            )

        }
    }
}