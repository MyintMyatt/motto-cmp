package com.orion.motto_cmp.common.components.app

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mottocmp.composeapp.generated.resources.Res
import mottocmp.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppLogo(
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter =  painterResource(Res.drawable.logo),
        contentDescription = "logo"
    )
}