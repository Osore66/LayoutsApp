package com.pmdm.layoutsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.layoutsapp.ui.theme.LayoutsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android", Modifier.height(100.dp))
                    MyBox()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, myModifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .width(120.dp)
    ) {

        Text(
            text = "Hello $name!",
            modifier = myModifier
        )

        Text(
            text = "Horas no aprobadas para FCT: ${horas()}",
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(50.dp)
                .padding(4.dp)
        )
    }
}

fun horas() = (2000 - 400) * 0.15

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutsAppTheme {
        Greeting("AIVÆN", Modifier.height(100.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    LayoutsAppTheme {
        MyBox()
    }
}

@Composable
fun MyBox() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Box(
            modifier = Modifier
                .width(20.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center
        ) {
            Text("Esto es un EJEMPLO")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun myNewBox(){
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Holita",
            modifier = Modifier.background(Color.Green))
    }
}