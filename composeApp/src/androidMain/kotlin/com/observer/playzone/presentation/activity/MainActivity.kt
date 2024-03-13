package com.observer.playzone.presentation.activity



import android.os.Bundle
import androidx.activity.ComponentActivity
import com.observer.playzone.presentation.navigation.setupThemedNavigation


class MainActivity() : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupThemedNavigation()
    }
}

