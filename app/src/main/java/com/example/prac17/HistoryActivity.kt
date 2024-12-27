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
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

class HistoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Prac17Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainHistory()
                }
            }
        }
    }
}
@Composable
fun MainHistory() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = WindowInsets.systemBars.asPaddingValues().calculateTopPadding(),
            bottom = WindowInsets.systemBars.asPaddingValues().calculateBottomPadding())) {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    modifier = Modifier.offset(x = 0.dp, y = 0.dp),
                    title = {
                        Text(
                            "History",
                            color = Color.Black,
                            modifier = Modifier.offset(x = 50.dp, y = 0.dp)
                        )
                    },
                    backgroundColor = Color.Yellow,
                    actions = {
                        Box(modifier = Modifier.size(40.dp)) {
                            IconButton(
                                onClick = {
                                    scope.launch {
                                        scaffoldState.drawerState.open()
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .offset(x = -340.dp, y = 0.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.menu),
                                    contentDescription = "Menu",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }
                )
            },
            drawerContent = {
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp)) {
                    Text(
                        "Main",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable(onClick = {
                                val intent = Intent(context, GlavActivity::class.java)
                                context.startActivity(intent)
                            })
                    )
                    Text(
                        "Settings",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable(onClick = {
                                val intent = Intent(context, SettingsActivity::class.java)
                                context.startActivity(intent)
                            })
                    )
                }
            },
            content = { content ->
                Box(modifier = Modifier.fillMaxSize()) {
                    GlavHistory()
                }
            }
        )
    }
}


@Composable
fun GlavHistory() {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.istory),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.temnbtn),
                contentDescription = null,
                modifier = Modifier
                    .offset(x = 0.dp, y = 200.dp)
                    .width(260.dp)
                    .size(50.dp)
                    .clickable(onClick = {
                        val intent = Intent(context, GlavActivity::class.java)
                        context.startActivity(intent)
                    })
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingFivePreview() {
    Prac17Theme {
        GlavHistory()
    }
}