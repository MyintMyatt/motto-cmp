package com.orion.motto_cmp

class JsPlatform: Platform {
    override val name: String = "Web with Kotlin/JS"
}

actual fun getX Platform(): Platform = JsPlatform()