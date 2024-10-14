package com.example.conposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conposebasic.ui.theme.ConposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConposeBasicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "吳昕恩",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //var x by remember { mutableStateOf(0) }
    var x = remember { mutableStateOf(0) }
    Column {
        Row {
            Button(onClick = {
                x.value = 0
            }) {
                Text("歸零")
                Image(
                    painter = painterResource(id = R.drawable.aaa),
                    contentDescription = "存錢吧",
                    modifier = modifier.size(40.dp)
                )
            }
            Button(onClick = {
                x.value = x.value * 2
            }) {
                Text("*2")
                Image(
                    painter = painterResource(id = R.drawable.aaa),
                    contentDescription = "存錢吧",
                    modifier = modifier.size(40.dp)
                )
            }
        }
        /*Text(text =x.toString(), 用by的寫法
            fontSize =50.sp,
            modifier = modifier.clickable { x++ },)*/
        Text(text =x.value.toString(),
            fontSize =50.sp,
            modifier = modifier.clickable { x.value++ },)

        Row {
            Text(
                text = stringResource(R.string.author),
                color = Color.Blue,
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(R.font.hand)),

                )
            Image(
                painter = painterResource(id = R.drawable.tcyang1),
                contentDescription = "子青快樂旅遊照",
                alpha = 0.8f,
                modifier = modifier.clip(CircleShape),
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.tcyang1),
                contentDescription = "子青快樂",
                alpha = 0.8f,
                modifier = modifier.clip(CircleShape),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConposeBasicTheme {
        Greeting("Android")
    }
}