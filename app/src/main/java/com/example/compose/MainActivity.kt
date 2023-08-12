package com.example.compose

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposeTheme {

                    ShopUi()

            }

        }
    }
}

@Composable
fun ShopUi(){


    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {

        Box(modifier = Modifier
            .fillMaxWidth()
            , contentAlignment = Alignment.TopCenter)
        {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(80.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween) {

                IconButton(onClick = { }
                    , modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .clip(CircleShape)
                        .background(color = Color(0xFFFABBD5))
                        , colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White
                        )


                    ) {
                    Icon(
                        painterResource(id = R.drawable.back_ios) ,
                        contentDescription = "",
                        modifier = Modifier
                            .height(25.dp)
                            .width(25.dp))

                }


                Text(text ="Product Detail",
                modifier = Modifier
                    .padding(top = 5.dp, end = 160.dp)
                    , fontWeight = FontWeight.Bold
                        , fontSize = 22.sp

                    )



            }

        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Image(painter =
            painterResource
                (id =  R.drawable.shoes)
                , contentDescription = "",
                modifier = Modifier
                    .width(300.dp)
                    .height(400.dp))
        }


        Row(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(end = 110.dp, start = 110.dp)
            , verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.SpaceEvenly) {


                IconButton(onClick = { },
                    Modifier
                        .width(30.dp)
                        .height(30.dp)
                        .clip(CircleShape),
                    colors = IconButtonDefaults
                        .iconButtonColors(
                            containerColor = Color(0xFFF9FFF5)
                        )
                ) {


                    Icon(
                        painterResource(id = R.drawable.minus2)
                        , contentDescription = "",
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                        )

                }




            Button(onClick = { },
               modifier= Modifier
                   .width(60.dp)
                   .height(60.dp)
                    , colors = ButtonDefaults
                    .buttonColors(
                        containerColor = Color(0xFFFABBD5)),
                shape = CircleShape
            ) {
                Text(text = "1", fontSize = 30.sp,
                    textAlign = TextAlign.Center
               )
            }

            IconButton(onClick = { },
                Modifier
                    .width(30.dp)
                    .height(30.dp),
                 colors = IconButtonDefaults
                    .iconButtonColors(
                        containerColor = Color(0xFFF9FFF5)
                    )

            ) {
                Icon(
                    painterResource(id = R.drawable.plus1)
                    , contentDescription = "",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            , verticalAlignment = Alignment.Top
            , horizontalArrangement = Arrangement.SpaceBetween){


            Column(modifier = Modifier.fillMaxHeight()) {

                Text(text = "Living room",
                    fontWeight = FontWeight.Light,
                modifier = Modifier.padding(start = 5.dp)
                )
                Text(text = "Leatherette Chair",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 5.dp)
                , fontSize = 22.sp)
            }
            Text(text = "$30.99",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 5.dp, top = 5.dp),
            fontSize = 26.sp
            )
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            , verticalAlignment = Alignment.Top
            , horizontalArrangement = Arrangement.SpaceBetween){

            Column(modifier = Modifier.fillMaxHeight()) {
                Text(text = "Hello Every one",
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 5.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, end = 12.dp, start = 12.dp)
                    ,
                horizontalArrangement = Arrangement.SpaceBetween) {

                    UiButton(color = Color(0xFFFF7B45))
                    UiButton(color = Color(0xFF83B0FF))
                    UiButton(color = Color(0xFFFABBD5))
                    UiButton(color = Color(0xFFA6FF6F))

                }
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(end = 10.dp, start = 10.dp)
            , verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.SpaceBetween) {

            IconButton(onClick = { }
                , modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .clip(CircleShape)
                    .border(
                        border = BorderStroke
                            (
                            width = 1.dp,
                            color = Color.Black
                        ), shape = CircleShape
                    ),

            ) {
                Icon(
                    painterResource(id = R.drawable.ic_favorite) ,
                    contentDescription = "",
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp))
            }


            Button(onClick = { }
                , modifier = Modifier
                    .height(60.dp)
                    .width(310.dp)
                , shape = shapes.extraLarge,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black)
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
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
       ShopUi()
    }
}