package com.orion.motto_cmp.common.components.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.orion.motto_cmp.ui.GetAuxMono
import mottocmp.composeapp.generated.resources.Res
import mottocmp.composeapp.generated.resources.app_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun AppName(
    title : String = stringResource(Res.string.app_title),
    style: TextStyle = MaterialTheme.typography.titleMedium,
    color: Color = MaterialTheme.colorScheme.onSurface
){
    Text(
        text = title,
        fontFamily = GetAuxMono(),
        style = style,
        color = color
    )
}