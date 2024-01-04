package com.observer.playzone

class Greeting {
    fun greet(): String {
        return "Hello, ${Platform().platform}!"
    }
}