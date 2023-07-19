package com.example.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm() {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var isButtonEnabled by remember { mutableStateOf(true) }
    val context = LocalContext.current


    Image(painter = painterResource(id = R.drawable.bg),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize())

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
        .wrapContentSize(
            align = Alignment.Center
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {


        TextField(

            value = username,
            onValueChange = { username = it },
            label = { Text("username", color = Color(0xFFCCCCCC)) },
            isError = showError && !isUsernameValid(username),
            colors = TextFieldDefaults.textFieldColors(
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.White,
                errorCursorColor = Color.Red,
                errorIndicatorColor = Color.Red,
                errorLabelColor = Color.Red
            ),
            leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "",
                tint = Color(0xFFCCCCCC)
            )} ,
            shape = shapes.medium,


            )


        TextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "",
                tint = Color(0xFFCCCCCC)
            )} ,
            label = { Text("password", color = Color(0xFFCCCCCC))} ,
            isError = showError && !isPasswordValid(password),
            colors = TextFieldDefaults.textFieldColors(
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.White,
                errorCursorColor = Color.Red,
                errorIndicatorColor = Color.Red,
                errorLabelColor = Color.Red
            ),
            shape = shapes.medium,
            singleLine = true,
        )

        Button(
            onClick = {
                showError = true
                if (isUsernameValid(username) && isPasswordValid(password)) {
                    Toast.makeText(context,"ورود موفقیت آمیز",Toast.LENGTH_SHORT).show()

                }
                Toast.makeText(context,"نام کاربری نباید با عدد شروع شود" +
                        "    "+ "" +
                        "رمز عبور باید دارای حروف انگلیسی بزرگ + کاراکتر + عدد باشد",Toast.LENGTH_SHORT).show()

            },
            enabled = isButtonEnabled,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("login")
        }

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