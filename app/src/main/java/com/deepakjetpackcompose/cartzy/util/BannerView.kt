package com.deepakjetpackcompose.cartzy.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType


@Composable
fun BannerView(modifier: Modifier = Modifier) {

    var banner by remember { mutableStateOf<List<String>>(emptyList()) }

    LaunchedEffect(Unit) {
        Firebase.firestore.collection("data").document("banner").get().addOnCompleteListener {
            banner=it.result.get("urls") as List<String>
        }
    }

    Column (modifier = modifier){
        var pageState = rememberPagerState (initialPage = 0){ banner.size }
        HorizontalPager(
            state = pageState,
            pageSpacing = 24.dp
        ) {
            AsyncImage(
                model = banner[it],
                contentDescription = null,
                modifier= Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
            )
        }
        Spacer(Modifier.height(10.dp))
        DotsIndicator(
            dotCount = banner.size,
            pagerState = pageState,
            type = ShiftIndicatorType(DotGraphic(color = MaterialTheme.colorScheme.primary,
                size = 6.dp))
        )
    }
    
}