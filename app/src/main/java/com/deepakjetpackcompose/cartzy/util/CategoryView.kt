package com.deepakjetpackcompose.cartzy.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.deepakjetpackcompose.cartzy.model.CategoryModel
import com.deepakjetpackcompose.cartzy.navigation.GlobalNavigation
import com.deepakjetpackcompose.cartzy.navigation.NavigationDestination
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

@Composable
fun CategoryView(modifier: Modifier = Modifier) {

    val categoryList= remember { mutableStateOf<List<CategoryModel>>(emptyList()) }
    LaunchedEffect(Unit) {
        Firebase.firestore.collection("data").document("stock")
            .collection("category")
            .get().addOnCompleteListener {
                if(it.isSuccessful){
                    val result=it.result.documents.mapNotNull {doc->
                        doc.toObject(CategoryModel::class.java)
                    }
                    categoryList.value=result
                }
            }
    }

    LazyRow(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
        items (categoryList.value){item->
            CategoryCard(categoryModel = item)
        }
    }
    
}

@Composable
fun CategoryCard(categoryModel: CategoryModel,modifier: Modifier = Modifier) {

    Card (
        modifier = Modifier
            .size(100.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ){
        Column (verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = {
                    GlobalNavigation.navController.navigate("${NavigationDestination.CategoryProductPage.route}/${categoryModel.id}")
                })){
            AsyncImage(model = categoryModel.imgUrl,
                contentDescription = null,
                modifier = Modifier.size(50.dp))
            Spacer(Modifier.height(8.dp))
            Text(text = categoryModel.name, color = MaterialTheme.colorScheme.secondary, textAlign = TextAlign.Center)
        }
    }

}