package com.orion.motto_cmp.features.reading.model

import mottocmp.composeapp.generated.resources.Res
import mottocmp.composeapp.generated.resources.book_black
import mottocmp.composeapp.generated.resources.book_white
import mottocmp.composeapp.generated.resources.zip
import org.jetbrains.compose.resources.DrawableResource

data class ReadingModule(
    val title : String,
    val desc : String,
    val img : DrawableResource,
    val imgBlack : DrawableResource? = null
)

val ReadingPageModuleList =  listOf(
    ReadingModule(
        title = "JLPT READING",
        desc = "Strategically selected exercises to equip you with essential skills for the tests.",
        img = Res.drawable.book_white,
        imgBlack = Res.drawable.book_black
    ),
    ReadingModule(
        title = "SPEED RUN",
        desc = "Accelerate and sharpen your reading speed & accuracy by doing custom drills.",
        img = Res.drawable.zip,
        imgBlack = Res.drawable.zip,
    )
)