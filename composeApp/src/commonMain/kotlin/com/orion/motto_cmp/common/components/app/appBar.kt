package com.orion.motto_cmp.common.components.app

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesomeMosaic
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    modifier: Modifier = Modifier
){
    Card(
        onClick = {}
    ){
        Row(
            modifier = Modifier
                .height(56.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // APP LOGO
            AppLogo()
            // SPACE
            Spacer(modifier = Modifier.weight(.1f))

            // APP NAME
            AppName()

            // SPACE
            Spacer(modifier = Modifier.weight(1.5f))

            Icon(
                imageVector = Icons.Rounded.AutoAwesomeMosaic,
                contentDescription = "icon",
            )

            // THEME TOGGLE ICON
//            ThemeToggleButton(
//                isDarkMode = isDarkTheme,
//                onToggle = onThemeToggle,
//                animate = animateIcon,
//                isToggleEnabled = isToggleEnabled
//            )

        }
    }
}