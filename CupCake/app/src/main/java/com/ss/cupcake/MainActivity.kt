package com.ss.cupcake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.example.cupcake.CupcakeApp
import com.ss.cupcake.ui.theme.CupCakeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CupCakeTheme() {
                CupcakeApp()
            }
        }
    }
}
