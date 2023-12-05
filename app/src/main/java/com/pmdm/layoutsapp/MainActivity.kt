package com.pmdm.layoutsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
                    MyComplexLayout()
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
        MyComplexLayout()
    }
}


@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState()),
        //con row arrangement y aligment serían al revés
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        My2Text()
        My2Text()
//        My2Text()
//        My2Text()
//        My2Text()
//        My2Text()
//        My2Text()
    }
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState()),
        //con row arrangement y aligment serían al revés
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        My2Text()
//        My2Text()
//        My2Text()
//        My2Text()
//        My2Text()
//        My2Text()
//        My2Text()
    }
}

@Composable
fun My2Text() {
    Text(
        text = "Adios",
        modifier = Modifier
            .background(Color.Blue)
            .padding(35.dp)
    )
    Text(
        text = "Hola",
        modifier = Modifier
            .background(Color.Green)
            .padding(30.dp)
    )
}

@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
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

@Composable
fun myNewBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Text(
            text = "Adios Adios Adios Adios Adios Adios Adios ",
            modifier = Modifier.background(Color.Blue)
        )
        Text(
            text = "HolaVecinito",
            modifier = Modifier.background(Color.Green)
        )
    }
}

@Composable
fun MyComplexLayout() {
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 25.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .background(Color.Cyan)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1 / 3f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Red)
            )
            Spacer(modifier = Modifier.width(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Magenta),
                contentAlignment = Alignment.Center
            )
            {
                Text("Hola clase!")
            }
        }
        MySpacerHeight(height = 400)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Gray)
        )
    }
}

@Composable
fun MySpacerHeight(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}

//    Esto no se puede hacer porqe el peso es un valor
//    relativo al padre y no tenemos acceso a esa información

//    @Composable
//    fun MySpacerWeight(weight:Int) {
//        Spacer(modifier = Modifier.weight(weight))
//    }
