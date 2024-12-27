package com.example.prac17

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prac17.ui.theme.Prac17Theme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Prac17Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Nachlay()
                }
            }
        }
    }
}

@Composable
fun Nachlay() {
    val context = LocalContext.current
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(1000) // задержка в 1 секунду перед появлением логотипа
        visible = true

    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.nachtema),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(
                visible = visible,
                enter = slideInHorizontally() + expandHorizontally(expandFrom = Alignment.Start) + fadeIn(),
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(100.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.signin),
            contentDescription = null,
            modifier = Modifier
                .offset(x = 65.dp, y = 500.dp)
                .width(260.dp)
                .size(50.dp)
                .clickable(onClick = {val intent = Intent(context,LoginActivity::class.java)
                    context.startActivity(intent)} )
        )
        Text(
            text = "Еще не зарегестрированны?",
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier
                .offset(x= 120.dp,y= 550.dp)
                .clickable(onClick = {
                    val intent = Intent(context, RegActivity::class.java)
                    context.startActivity(intent)})
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Prac17Theme {
        Nachlay()
    }
}