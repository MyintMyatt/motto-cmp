package com.orion.motto_cmp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {
    @Serializable object Home : Screen
    @Serializable object Reading : Screen
    @Serializable object Kanji : Screen
    @Serializable object HiraganaNKatakana : Screen
    @Serializable object Grammar : Screen
    @Serializable object Listening : Screen
    @Serializable object Vocabulary : Screen
    @Serializable object Setting : Screen
}