package com.orion.motto_cmp.common.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.orion.motto_cmp.common.components.app.AppBar
import com.orion.motto_cmp.common.components.bottom_nav.BottomNav

@Composable
fun MainLayout(
    isShowAppBar: Boolean = false,
    content: @Composable () -> Unit,
    isShowBottomNav: Boolean = false,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 15.dp)
                .padding(top = 10.dp)
                .safeContentPadding()
        ) {
            AppBar()
            content()
            Spacer(modifier = Modifier.weight(1f))
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp)
        ) {
            BottomNav()
        }
    }
}