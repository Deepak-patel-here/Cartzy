package com.deepakjetpackcompose.cartzy.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

@Preview
@Composable
fun HeaderHome(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        Firebase.firestore.collection("users").document(FirebaseAuth.getInstance().currentUser?.uid!!)
            .get().addOnCompleteListener {
                name=it.result.get("name").toString().split(" ").get(0)
            }
    }

    Row(modifier = modifier
        .fillMaxWidth()
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Column(verticalArrangement = Arrangement.Center) {
            Text("Welcome back!", color = MaterialTheme.colorScheme.primary, fontSize = 16.sp)
            Text(
                name,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            modifier= Modifier.size(25.dp),
            tint = MaterialTheme.colorScheme.primary
        )
    }

}