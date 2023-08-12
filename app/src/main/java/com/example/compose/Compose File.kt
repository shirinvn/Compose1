package com.example.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        )
        } ,
        label = { Text(text = "password") } ,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            containerColor = Color.Transparent,
            textColor = Color.White,

            ),
        shape = MaterialTheme.shapes.medium,
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
        ),
        leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "",
            tint = Color(0xFFCCCCCC)
        )
        } ,
        shape = MaterialTheme.shapes.medium,
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
        shape= MaterialTheme.shapes.medium,
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



////////////////////////////// ui 2



/*@Composable
fun ShopUi(){


    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {

        _root_ide_package_.androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .fillMaxWidth(), contentAlignment = Alignment.TopCenter
        )
        {
            _root_ide_package_.androidx.compose.foundation.layout.Row(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(80.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = _root_ide_package_.androidx.compose.foundation.layout.Arrangement.SpaceBetween
            ) {

                _root_ide_package_.androidx.compose.material3.IconButton(onClick = { },
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .clip(_root_ide_package_.androidx.compose.foundation.shape.CircleShape)
                        .background(color = Color(0xFFFABBD5)),
                    colors = _root_ide_package_.androidx.compose.material3.IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White
                    )


                ) {
                    Icon(
                        painterResource(id = R.drawable.back_ios),
                        contentDescription = "",
                        modifier = Modifier
                            .height(25.dp)
                            .width(25.dp)
                    )

                }


                Text(
                    text = "Product Detail",
                    modifier = Modifier
                        .padding(top = 5.dp, end = 160.dp),
                    fontWeight = _root_ide_package_.androidx.compose.ui.text.font.FontWeight.Bold,
                    fontSize = 22.sp

                )


            }

        }
        _root_ide_package_.androidx.compose.foundation.layout.Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = _root_ide_package_.androidx.compose.foundation.layout.Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter =
                painterResource
                    (id = R.drawable.shoes), contentDescription = "",
                modifier = Modifier
                    .width(300.dp)
                    .height(400.dp)
            )
        }


        _root_ide_package_.androidx.compose.foundation.layout.Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(end = 110.dp, start = 110.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = _root_ide_package_.androidx.compose.foundation.layout.Arrangement.SpaceEvenly
        ) {


            _root_ide_package_.androidx.compose.material3.IconButton(
                onClick = { },
                Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .clip(_root_ide_package_.androidx.compose.foundation.shape.CircleShape),
                colors = _root_ide_package_.androidx.compose.material3.IconButtonDefaults
                    .iconButtonColors(
                        containerColor = Color(0xFFF9FFF5)
                    )
            ) {


                Icon(
                    painterResource(id = R.drawable.minus2), contentDescription = "",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )

            }




            Button(
                onClick = { },
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp), colors = ButtonDefaults
                    .buttonColors(
                        containerColor = Color(0xFFFABBD5)
                    ),
                shape = _root_ide_package_.androidx.compose.foundation.shape.CircleShape
            ) {
                Text(
                    text = "1", fontSize = 30.sp,
                    textAlign = _root_ide_package_.androidx.compose.ui.text.style.TextAlign.Center
                )
            }

            _root_ide_package_.androidx.compose.material3.IconButton(
                onClick = { },
                Modifier
                    .width(30.dp)
                    .height(30.dp),
                colors = _root_ide_package_.androidx.compose.material3.IconButtonDefaults
                    .iconButtonColors(
                        containerColor = Color(0xFFF9FFF5)
                    )

            ) {
                Icon(
                    painterResource(id = R.drawable.plus1), contentDescription = "",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            }
        }

        _root_ide_package_.androidx.compose.foundation.layout.Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = _root_ide_package_.androidx.compose.foundation.layout.Arrangement.SpaceBetween
        ) {


            Column(modifier = Modifier.fillMaxHeight()) {

                Text(
                    text = "Living room",
                    fontWeight = _root_ide_package_.androidx.compose.ui.text.font.FontWeight.Light,
                    modifier = Modifier.padding(start = 5.dp)
                )
                Text(
                    text = "Leatherette Chair",
                    fontWeight = _root_ide_package_.androidx.compose.ui.text.font.FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 5.dp), fontSize = 22.sp
                )
            }
            Text(
                text = "$30.99",
                fontWeight = _root_ide_package_.androidx.compose.ui.text.font.FontWeight.Bold,
                modifier = Modifier.padding(end = 5.dp, top = 5.dp),
                fontSize = 26.sp
            )
        }

        _root_ide_package_.androidx.compose.foundation.layout.Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = _root_ide_package_.androidx.compose.foundation.layout.Arrangement.SpaceBetween
        ) {

            Column(modifier = Modifier.fillMaxHeight()) {
                Text(
                    text = "Hello Every one",
                    fontWeight = _root_ide_package_.androidx.compose.ui.text.font.FontWeight.Light,
                    modifier = Modifier.padding(start = 5.dp)
                )
                _root_ide_package_.androidx.compose.foundation.layout.Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, end = 12.dp, start = 12.dp),
                    horizontalArrangement = _root_ide_package_.androidx.compose.foundation.layout.Arrangement.SpaceBetween
                ) {

                    UiButton(color = Color(0xFFFF7B45))
                    UiButton(color = Color(0xFF83B0FF))
                    UiButton(color = Color(0xFFFABBD5))
                    UiButton(color = Color(0xFFA6FF6F))

                }
            }
        }

        _root_ide_package_.androidx.compose.foundation.layout.Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .padding(end = 10.dp, start = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = _root_ide_package_.androidx.compose.foundation.layout.Arrangement.SpaceBetween
        ) {

            _root_ide_package_.androidx.compose.material3.IconButton(
                onClick = { },
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .clip(_root_ide_package_.androidx.compose.foundation.shape.CircleShape)
                    .border(
                        border = BorderStroke
                            (
                            width = 1.dp,
                            color = Color.Black
                        ), shape = CircleShape
                    ),

                ) {
                Icon(
                    painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "",
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp)
                )
            }


            Button(onClick = { }, modifier = Modifier
                .height(60.dp)
                .width(310.dp), shape = shapes.extraLarge,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(text = "Add to Cart")


            }


        }

    }

}
@Composable
fun UiButton(color: Color){
    Button(onClick = { }
        , modifier = Modifier
            .height(70.dp)
            .width(80.dp)
            .border(
                border = BorderStroke(
                    width = 0.5.dp, color = Color.Black
                ), shape = RoundedCornerShape(12.dp)
            )
        , shape = shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = color)
    ) {}
}*/

