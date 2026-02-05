package com.orion.motto_cmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform