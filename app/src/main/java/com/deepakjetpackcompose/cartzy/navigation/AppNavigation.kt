package com.deepakjetpackcompose.cartzy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.deepakjetpackcompose.cartzy.screen.GetStartedScreen
import com.deepakjetpackcompose.cartzy.screen.LoginScreen
import com.deepakjetpackcompose.cartzy.screen.SignUpScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
     val navController=rememberNavController()

     NavHost(navController = navController, startDestination = NavigationDestination.GetStarted.route) {
          composable (route = NavigationDestination.GetStarted.route){
               GetStartedScreen(navController=navController)
          }

          composable (route = NavigationDestination.LoginScreen.route){
               LoginScreen(navController=navController)
          }

          composable(route = NavigationDestination.SignUpScreen.route) {
               SignUpScreen(navController=navController)
          }
     }
    
}