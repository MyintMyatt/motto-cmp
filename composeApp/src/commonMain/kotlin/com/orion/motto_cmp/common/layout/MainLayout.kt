package com.orion.motto_cmp.common.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable

@Composable
fun MainLayout(
    isShowAppBar: Boolean = false,
    content: @Composable () -> Unit,
    isShowBottomNav: Boolean = false,
){
    Box(){
        content()
    }
}