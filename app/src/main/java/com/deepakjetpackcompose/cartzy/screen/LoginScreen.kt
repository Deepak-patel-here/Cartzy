package com.deepakjetpackcompose.cartzy.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.deepakjetpackcompose.cartzy.R
import com.deepakjetpackcompose.cartzy.navigation.NavigationDestination
import com.deepakjetpackcompose.cartzy.ui.theme.CartzyTheme
import com.deepakjetpackcompose.cartzy.util.AppToast
import com.deepakjetpackcompose.cartzy.viewmodel.AuthViewModel

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel= viewModel(), modifier: Modifier = Modifier) {

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isShow by rememberSaveable { mutableStateOf(false) }
    val passwordFocus = remember { FocusRequester() }
    val keyboard = LocalSoftwareKeyboardController.current
    var eyeIcon = if (isShow) R.drawable.show else R.drawable.hide
    var isLoading by remember{mutableStateOf(false)}
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(MaterialTheme.colorScheme.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            "Welcome back!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.primary
            )
        )
        Spacer(Modifier.height(5.dp))

        Text(
            "Login to your account",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.primary
            )
        )
        Spacer(Modifier.height(20.dp))

        Image(
            painter = painterResource(R.drawable.login2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.primary
            ),
            label = { Text("Email") },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.email),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(30.dp)
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {
                    passwordFocus.requestFocus()
                }
            ),
            shape = RoundedCornerShape(12.dp)
        )



        Spacer(Modifier.height(15.dp))

        OutlinedTextField(
            modifier = Modifier.focusRequester(passwordFocus),
            value = password,
            onValueChange = { password = it },
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.primary
            ),
            label = { Text("Password") },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.lock),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(30.dp)
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboard?.hide()
                }
            ),
            shape = RoundedCornerShape(12.dp),
            trailingIcon = {
                IconButton(onClick = {
                    isShow = !isShow
                }) {
                    Icon(
                        painter = painterResource(eyeIcon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(25.dp)
                    )
                }

            },
            visualTransformation = if(isShow) VisualTransformation.None else  PasswordVisualTransformation()
        )

        Spacer(Modifier.height(25.dp))

        Button(
            onClick = {
                isLoading=true
                authViewModel.login (email = email, password = password){success,msg->
                    if(success){
                        isLoading=false
                        navController.navigate(NavigationDestination.HomeScreen.route){
                            popUpTo(NavigationDestination.LoginScreen.route){inclusive=true}
                        }
                    }else{
                        isLoading=false
                        AppToast(context=context, msg = msg.toString())
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),

        ) {
            Text("Login", fontSize = 22.sp)
            Spacer(Modifier.width(5.dp))
            if(isLoading){
                CircularProgressIndicator(color = MaterialTheme.colorScheme.onPrimary)
            }
        }

        Spacer(Modifier.height(20.dp))
        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()){
            Text(
                "Don't have an account?",
                modifier = Modifier,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.SansSerif,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
            )

            Text(
                "signup",
                modifier = Modifier.clickable(onClick = {
                    navController.navigate(NavigationDestination.SignUpScreen.route){
                        popUpTo(NavigationDestination.LoginScreen.route){inclusive=true}
                    }
                }),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
            )



        }



    }

}

@Preview
@Composable
private fun LoginPrev() {
    CartzyTheme {
        LoginScreen(navController = rememberNavController())
    }

}