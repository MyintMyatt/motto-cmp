package com.orion.motto_cmp.features.home.data

import androidx.compose.ui.graphics.Color
import com.orion.motto_cmp.navigation.Screen

data class HomePageModule(val title: String, val desc: String, val icon: String, val color: Color, val route: Screen)

val HomePageModules = listOf(
    HomePageModule(
        "READING", """
                         Improve your reading
                         comprehension with texts
                         tailored for your level
                         """, "読", Color(0xFFA5F3FC),
        route = Screen.Reading
    ),
    HomePageModule(
        "KANJI", """
                         Learn, review and master 
                         kanji meanings,
                         readings, and usage
                         """, "字", Color(0xFFF5D0FE),
        route = Screen.Kanji
    ),
    HomePageModule(
        "GRAMMAR", """
                         Learn grammar patterns 
                         with practical examples
                         """, "文", Color(0xFF99F6E4),
        route = Screen.Grammar
    ),
    HomePageModule(
        "LISTENING", """
                        Develop listening skills
                        for your upcoming test
                         """, "聞", Color(0xFFFBCFE8),
        route = Screen.Listening
    ),
    HomePageModule(
        "VOCABULARY", """
                        Build your word bank
                        with spaced repetition
                         """, "言", Color(0xFFFEF08A),
        route = Screen.Vocabulary
    ),

    )
