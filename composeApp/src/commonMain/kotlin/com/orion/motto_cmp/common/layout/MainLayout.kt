package com.orion.motto_cmp.common.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.orion.motto_cmp.common.components.app.AppBar

@Composable
fun MainLayout(
    isShowAppBar: Boolean = false,
    content: @Composable () -> Unit,
    isShowBottomNav: Boolean = false,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .safeContentPadding()
    ) {
        AppBar()
        content()
    }
}