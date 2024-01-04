package com.observer.playzone

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.RELEASE}"
}

