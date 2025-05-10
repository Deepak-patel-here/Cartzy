package com.deepakjetpackcompose.cartzy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.deepakjetpackcompose.cartzy.navigation.AppNavigation
import com.deepakjetpackcompose.cartzy.ui.theme.CartzyTheme
import com.deepakjetpackcompose.cartzy.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val authViewModel: AuthViewModel by viewModels()
            CartzyTheme {
                Scaffold {innerPadding->
                    AppNavigation(modifier = Modifier.padding(innerPadding),authViewModel)
                }
            }
        }
    }
}

