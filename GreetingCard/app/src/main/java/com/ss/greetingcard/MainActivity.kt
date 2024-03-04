package com.ss.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss.greetingcard.ui.theme.GreetingCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingScreen("John","Emma","Happy Christmas!")

                }
            }
        }
    }
}

@Composable
fun GreetingText(to:String, from:String, msg: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Transparent) {
        Column (
            modifier = Modifier
                .padding(20.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly

        ){

            Text(
                text = stringResource(R.string.hello_text) +to+',',
                modifier = modifier
                    .padding(0.dp)
                    .align(alignment = Alignment.Start)
                ,
                color = Color.Black,
                fontSize = 35.sp,
                textAlign = TextAlign.Center
            )


            Text(
                text = "$msg",
                modifier = modifier
                    .padding(0.dp)
                ,
                color = Color.Black,
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 70.sp
            )


            Text(
                text = stringResource(R.string.from1_text) +from,
                modifier = modifier
                    .padding(0.dp)
                    .align(alignment = Alignment.End)
                ,
                color = Color.Black,
                fontSize = 35.sp,
                textAlign = TextAlign.Center
            )

        }
    }
}

@Composable
fun GreetingScreen(to:String, from:String, msg: String, modifier: Modifier = Modifier) {
    Surface(color = Color.White) {
        Box (
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.9F)
                .wrapContentSize(Alignment.Center),

            ){

            val image = painterResource(R.drawable.androidparty)
            // Background image
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            // Greeting text
            GreetingText(to,from,msg)


        }
    }
}

@Preview(
    showBackground = false,
    showSystemUi = true,
    name = "MyPreview"
)
@Composable
fun GreetingPreview() {
    GreetingCardTheme {
        GreetingScreen(stringResource(R.string.to_text), stringResource(R.string.from_text),
                    stringResource(R.string.msg_text)
                )
    }
}