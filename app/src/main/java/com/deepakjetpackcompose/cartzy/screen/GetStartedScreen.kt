package com.deepakjetpackcompose.cartzy.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.deepakjetpackcompose.cartzy.R
import com.deepakjetpackcompose.cartzy.navigation.NavigationDestination
import com.deepakjetpackcompose.cartzy.ui.theme.Inter


@Composable
fun GetStartedScreen(navController: NavController,modifier: Modifier = Modifier) {

    Column(modifier=modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.surface)
        .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.shopping),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Spacer(Modifier.height(20.dp))
        Text("Start your shopping journey now",
            style = TextStyle(
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
        )

        Spacer(Modifier.height(20.dp))
        Text("Best shopping platform with best prices",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
            , modifier = Modifier.alpha(0.7f)
        )

        Spacer(Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(NavigationDestination.LoginScreen.route){
                popUpTo(NavigationDestination.GetStarted.route){inclusive=true}
            }
        },
            modifier = Modifier.fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )) {
            Text("Login", fontSize = 22.sp)
        }

        Spacer(Modifier.height(10.dp))

        OutlinedButton(onClick = {
            navController.navigate(NavigationDestination.SignUpScreen.route){
                popUpTo(NavigationDestination.GetStarted.route){inclusive=true}
            }
        },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
        ) {
            Text("Signup", fontSize = 22.sp)
        }

    }

}