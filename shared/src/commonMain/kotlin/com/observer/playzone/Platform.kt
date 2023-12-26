package com.observer.playzone

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform