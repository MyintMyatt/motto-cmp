package com.orion.motto_cmp.common.components.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.orion.motto_cmp.ui.GetAuxMono

@Composable
fun TextTitle(
    title: String,
    style: TextStyle = MaterialTheme.typography.titleMedium
){
    Text(
        title,
        fontFamily = GetAuxMono(),
        style = style
    )
}