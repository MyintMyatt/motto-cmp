package com.orion.motto_cmp.features.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.orion.motto_cmp.ui.GetAuxMono

@Composable
fun HomeScreen(){
    Box(){
        Text("Hello", fontFamily = GetAuxMono())
    }
}