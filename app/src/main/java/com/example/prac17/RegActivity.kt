package com.example.prac17

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prac17.ui.theme.Prac17Theme

class RegActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Prac17Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Reglay()
                }
            }
        }
    }
}


@Composable
fun Reglay() {
    val context = LocalContext.current
    val name = remember { mutableStateOf("") }
    val Email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordtwo = remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.whitetema),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Name") },
            )
            OutlinedTextField(
                value = Email.value,
                onValueChange = { Email.value = it },
                label = { Text("Login") }

            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Password") }
            )
            OutlinedTextField(
                value = passwordtwo.value,
                onValueChange = { password.value = it },
                label = { Text("Password") }
            )
            Image(
                painter = painterResource(id = R.drawable.vhodbtn),
                contentDescription = null,
                modifier = Modifier
                    .offset(x = 0.dp, y = 10.dp)
                    .width(260.dp)
                    .size(50.dp)
                    .clickable(onClick = {val intent = Intent(context,GlavActivity::class.java)
                        context.startActivity(intent)} )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingOnePreview() {
    Prac17Theme {
        Reglay()
    }
}