package com.observer.playzone

actual class Platform actual constructor(){
    val a: NSString =  NSString.create(string = "Hello, Test")
    actual val platform: String = UIDevice.currentDevice.systemName() + "" + UIDevice.currentDevice.systemVersion
}

