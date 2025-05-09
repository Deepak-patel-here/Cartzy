package com.deepakjetpackcompose.cartzy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.deepakjetpackcompose.cartzy.navigation.AppNavigation
import com.deepakjetpackcompose.cartzy.ui.theme.CartzyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartzyTheme {
                Scaffold {innerPadding->
                    AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

