package com.deepakjetpackcompose.cartzy.pages

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CategoryProduct(categoryId:String,modifier: Modifier = Modifier) {

    Text("Hello category product page:::::$categoryId")

}