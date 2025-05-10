package com.deepakjetpackcompose.cartzy.util

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


fun AppToast(context: Context,msg:String,modifier: Modifier = Modifier) {
    Toast.makeText(context,msg, Toast.LENGTH_LONG).show()
}