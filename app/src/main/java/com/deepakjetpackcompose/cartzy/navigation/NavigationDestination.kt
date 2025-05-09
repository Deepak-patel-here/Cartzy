package com.deepakjetpackcompose.cartzy.navigation

sealed class NavigationDestination(var route:String) {
    object GetStarted: NavigationDestination("intro")
    object LoginScreen: NavigationDestination("login")
    object SignUpScreen: NavigationDestination("signup")
}