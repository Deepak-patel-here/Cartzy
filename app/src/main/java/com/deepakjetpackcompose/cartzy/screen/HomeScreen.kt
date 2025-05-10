package com.deepakjetpackcompose.cartzy.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.deepakjetpackcompose.cartzy.model.BottomBarModel
import com.deepakjetpackcompose.cartzy.pages.CartPage
import com.deepakjetpackcompose.cartzy.pages.FavPage
import com.deepakjetpackcompose.cartzy.pages.HomePage
import com.deepakjetpackcompose.cartzy.pages.ProfilePage

@Composable
fun HomeScreen(navController: NavController,modifier: Modifier = Modifier) {
    val navList=listOf<BottomBarModel>(
        BottomBarModel(label = "Home", img = Icons.Default.Home),
        BottomBarModel(label = "Favorite", img = Icons.Default.Favorite),
        BottomBarModel(label = "Cart", img = Icons.Default.ShoppingCart),
        BottomBarModel(label = "Profile", img = Icons.Default.Person)
    )
    var isSelected by remember{ mutableStateOf(0) }
    Scaffold (
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.primaryContainer, contentColor = MaterialTheme.colorScheme.onPrimaryContainer) {
                navList.forEachIndexed { index,navTo->
                    NavigationBarItem(
                        selected = index==isSelected,
                        icon = {
                            Icon(
                                imageVector = navTo.img,
                                contentDescription = null,
                                tint = if(isSelected==index) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier.size(
                                    if(isSelected==index){
                                        35.dp
                                    }else 25.dp
                                )
                            )
                        },
                        onClick = {
                            isSelected=index
                        },
                        label = {
                            if(isSelected !=index)
                            Text(navTo.label,
                                color =if(isSelected==index) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }

                    )
                }
            }
        }
    ){
        ContentScreen(modifier = modifier.padding(it),isSelected)
    }

}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, isSelected: Int) {
    when(isSelected){
        0-> HomePage()
        1-> FavPage()
        2-> CartPage()
        3-> ProfilePage()
    }
}

