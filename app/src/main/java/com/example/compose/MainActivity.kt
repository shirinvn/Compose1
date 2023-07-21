package com.example.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposeTheme {
                Surface(color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()) {
                    LoginForm()
                }
            }

        }
    }
}


@Composable
fun LoginForm() {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val isDataTrue by remember {
        derivedStateOf {

            username!="" && isUsernameValid(username) &&
            password!="" && isPasswordValid(password)

        }

    }


    Image(painter = painterResource(id = R.drawable.bg2),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize())

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
        .wrapContentSize(
            align = Alignment.Center
        ),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        UsernameText(username, onValueChange = {username=it}, "Username")
        UserPasswordText(password, onValueChange = {password= it},"Password" )

        UserButton(text = "Login", isEnabled=isDataTrue){

        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserPasswordText(value:String="", onValueChange: (String)-> Unit={}, label:String=""){


    OutlinedTextField(
        value = value,
        onValueChange = onValueChange ,
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "",
            tint = Color(0xFFCCCCCC)
        )} ,
        label = { Text(text = "password") } ,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            containerColor = Color.Transparent,
            textColor = Color.White,

        ),
        shape = shapes.medium,
        singleLine = true,
    )
    if (value == "" ){
        Text(text = "Password is required" , style = TextStyle(color = Color.Red))
    } else if (!isPasswordValid(value)){
        Text(text = "Password must be stronger" , style = TextStyle(color = Color.Red))
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsernameText (value:String="", onValueChange: (String)-> Unit={}, label:String=""){


    OutlinedTextField(
        value = value,
        onValueChange = onValueChange ,
      label = { Text(label) },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            containerColor = Color.Transparent,
            textColor = Color.White,
            unfocusedSupportingTextColor = Color.White,
            errorLabelColor = Color.Red,

        ),
        leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "",
            tint = Color(0xFFCCCCCC)
        )} ,
        shape = shapes.medium,
    )
    if (value == "" ){
        Text(text = "Username is required" , style = TextStyle(color = Color.Red))
    } else if (!isUsernameValid(value)){
        Text(text = "Must not start with a number" , style = TextStyle(color = Color.Red))
    }

}

@Composable
fun UserButton(text:String="", isEnabled:Boolean= false, onButtonClicked:()-> Unit={}){


    Button(
        onClick = onButtonClicked,
        modifier = Modifier.padding(top = 16.dp)
        ,
        enabled = isEnabled,
        shape= shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White,

        )
    ) {
        Text(text = text)
    }
}



private fun isUsernameValid(username: String): Boolean {
    val regex = Regex("^(?!\\d)[a-zA-Z0-9]+$")

    return regex.matches(username)
}

private fun isPasswordValid(password: String): Boolean {

    val regex = Regex("^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#\$%^&]).{6,}$")
    return regex.matches(password)
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
       LoginForm()
    }
}