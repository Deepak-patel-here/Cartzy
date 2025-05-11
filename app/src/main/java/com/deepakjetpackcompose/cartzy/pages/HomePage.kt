package com.deepakjetpackcompose.cartzy.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deepakjetpackcompose.cartzy.util.BannerView
import com.deepakjetpackcompose.cartzy.util.CategoryView
import com.deepakjetpackcompose.cartzy.util.HeaderHome

@Preview
@Composable
fun HomePage(modifier: Modifier = Modifier) {
    Column (modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.surface)
        .padding(16.dp)
        .systemBarsPadding()
    ){
        HeaderHome(modifier = modifier)
        Spacer(Modifier.height(10.dp))
        BannerView(modifier=modifier.height(190.dp))
        Text("Categories", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = MaterialTheme.colorScheme.primary)
        Spacer(Modifier.height(10.dp))
        CategoryView(modifier = modifier)
    }


}