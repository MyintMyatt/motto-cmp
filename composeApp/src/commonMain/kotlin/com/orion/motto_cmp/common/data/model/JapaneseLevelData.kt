package com.orion.motto_cmp.common.data.model

import com.orion.motto_cmp.common.constant.JapaneseLevel

data class JapaneseLevelData(
    val level: JapaneseLevel,
    val title: String,
    val desc: String
)


val japaneseLevelDataList = listOf(
    JapaneseLevelData(
        level = JapaneseLevel.N5,
        title = "Beginner",
        desc = "Foundations"
    ),
    JapaneseLevelData(
        level = JapaneseLevel.N4,
        title = "Elementary",
        desc = "Basic conversations"
    ),
    JapaneseLevelData(
        level = JapaneseLevel.N3,
        title = "Intermediate",
        desc = "Complex topics"
    ),
    JapaneseLevelData(
        level = JapaneseLevel.N2,
        title = "Upper Intermediate",
        desc = "More complex topics"
    ),
    JapaneseLevelData(
        level = JapaneseLevel.N1,
        title = "Intermediate",
        desc = "Advance complex topics"
    ),

    )