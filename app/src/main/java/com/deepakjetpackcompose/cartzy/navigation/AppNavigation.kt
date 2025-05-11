package com.deepakjetpackcompose.cartzy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.deepakjetpackcompose.cartzy.pages.CategoryProduct
import com.deepakjetpackcompose.cartzy.screen.GetStartedScreen
import com.deepakjetpackcompose.cartzy.screen.HomeScreen
import com.deepakjetpackcompose.cartzy.screen.LoginScreen
import com.deepakjetpackcompose.cartzy.screen.SignUpScreen
import com.deepakjetpackcompose.cartzy.viewmodel.AuthViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun AppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
     val navController=rememberNavController()
     GlobalNavigation.navController=navController
     val isLoggedIn= Firebase.auth.currentUser!=null
     val first=if(isLoggedIn) NavigationDestination.HomeScreen.route else NavigationDestination.GetStarted.route

     NavHost(navController = navController, startDestination = first) {
          composable (route = NavigationDestination.GetStarted.route){
               GetStartedScreen(navController=navController)
          }

          composable (route = NavigationDestination.LoginScreen.route){
               LoginScreen(navController=navController, authViewModel = authViewModel)
          }

          composable(route = NavigationDestination.SignUpScreen.route) {
               SignUpScreen(navController=navController, authViewmodel = authViewModel)
          }

          composable(route= NavigationDestination.HomeScreen.route) {
               HomeScreen(navController=navController)
          }

          composable(route= "${NavigationDestination.CategoryProductPage.route}/{categoryId}") {
               val categoryId=it.arguments?.getString("categoryId")
               CategoryProduct(categoryId = categoryId?:" ", modifier = modifier)
          }
     }
    
}

object GlobalNavigation{
     lateinit var navController : NavHostController
}