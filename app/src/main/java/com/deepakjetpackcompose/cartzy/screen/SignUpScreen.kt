package com.deepakjetpackcompose.cartzy.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.deepakjetpackcompose.cartzy.ui.theme.CartzyTheme
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.ImeOptions
import com.deepakjetpackcompose.cartzy.R
import com.deepakjetpackcompose.cartzy.navigation.NavigationDestination


@Composable
fun SignUpScreen(navController: NavController,modifier: Modifier = Modifier) {

    var email by rememberSaveable{ mutableStateOf("") }
    var name by rememberSaveable{ mutableStateOf("") }
    var password by rememberSaveable{ mutableStateOf("") }
    var isShow by rememberSaveable { mutableStateOf(false) }
    val nameFocus = remember { FocusRequester() }
    val passwordFocus = remember { FocusRequester() }
    val keyboard= LocalSoftwareKeyboardController.current
    Column (modifier = modifier
        .fillMaxSize()
        .padding(20.dp)
        .background(MaterialTheme.colorScheme.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Text("Sign Up",
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.onSurface
            )
        )
        Spacer(Modifier.height(10.dp))

        Text("Create a new Account",
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.onSurface
            )
        )
        Spacer(Modifier.height(20.dp))

        Image(
            painter = painterResource(R.drawable.login1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.primary
            ),
            label = {Text("Email")},
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.email),
                    contentDescription = null,
                    tint= MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(30.dp)
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {
                    nameFocus.requestFocus()
                }
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(Modifier.height(15.dp))

        OutlinedTextField(
            modifier = Modifier.focusRequester(nameFocus),
            value = name,
            onValueChange = {name=it},
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.primary
            ),
            label = {Text("Name")},
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.user),
                    contentDescription = null,
                    tint= MaterialTheme.colorScheme.primary,
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
            onValueChange = {password=it},
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.primary
            ),
            label = {Text("Password")},
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.lock),
                    contentDescription = null,
                    tint= MaterialTheme.colorScheme.primary,
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
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(Modifier.height(25.dp))

        Button(onClick = {

        },
            modifier = Modifier.fillMaxWidth()
                .height(60.dp).padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )) {
            Text("Signup", fontSize = 22.sp)
        }



    }
    
}

@PreviewLightDark
@Composable
private fun signupPreview() {
    CartzyTheme {
        SignUpScreen(navController = rememberNavController())
    }

}