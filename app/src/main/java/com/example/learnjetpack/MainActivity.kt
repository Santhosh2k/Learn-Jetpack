package com.example.learnjetpack

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learnjetpack.ui.theme.Green
import com.example.learnjetpack.ui.theme.LearnJetpackTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            LearnJetpackTheme {
                Surface(color = MaterialTheme.colorScheme.background)
                    { MyBottomAppBar() }
                }
            }
        }
    }

@Composable
fun DisplayText() {

    val clickText = {}

    Text(text = stringResource(R.string.text_one),
        color = Color.Yellow,
        fontSize = 32.sp, fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(22.dp)
            .background(Color.Red)
            .clickable(onClick = clickText))
}

@Composable
fun LearnRowColBox(){
//    Text(text = "Hello Column")
//    Text(text = "Hello Row")
//    Text(text = "Hello Box")

//    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//        Text(text = "Hellow Column1 ")
//        Text(text = "Hellow Column2 ")
//    }

    val clickBox = {}

    Row(horizontalArrangement = Arrangement.End) {
        Text(text = "Hello row 1")
        Text(text = "Hello row 2")
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow), contentAlignment = Alignment.Center){
        Box(modifier = Modifier
            .height(IntrinsicSize.Min)
            .width(300.dp)
            .background(Color.Blue)
            .clickable(onClick = clickBox), contentAlignment = Alignment.Center){
            Text(text = "Hello Box",
                color = colorResource(R.color.purple_200)
            )
        }
    }
}

@Composable
fun LearnAlignAndArrange(modifier: Modifier) {

//    Row(modifier = Modifier.fillMaxSize(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Absolute.Center) {
//        Text( text = "Align items in row 1" )
//    }

//    Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center) {
//        Text(text = "Column align")
//    }

    Box(modifier,contentAlignment = Alignment.BottomEnd) {
        Text(text = "Text align in Box", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun LearnButtonAndImage(modifier: Modifier){

    val context = LocalContext.current.applicationContext

    Column (verticalArrangement = Arrangement.Center, modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = { Toast.makeText(context,"Button Clicked",Toast.LENGTH_SHORT).show() },
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.Yellow)
        ) {
            Text("Login")
        }

        Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = "Image desc",modifier)
    }
}

@Composable
fun LearnState(fillMaxSize: Modifier) {
//    var age = 0
    var age by remember {
        mutableStateOf(0)
    }

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { age++
            Log.e("santhosh","$age \n")}) {

            Text(text = "Age :  $age")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnTopAppBar(){
    val context = LocalContext.current.applicationContext
    TopAppBar(title = { Text(text = "Whatsapp") },
        navigationIcon = {
            IconButton(onClick = {Toast.makeText(context,"Learn Whatsapp",Toast.LENGTH_SHORT).show()})
            {
                Icon(painter = painterResource(R.drawable.whatsapp_icon), contentDescription = "Whatsapp")
            }
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Green,
            titleContentColor = Color.White, navigationIconContentColor = Color.White),
        actions = {
            IconButton(
                onClick = { Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Person icon", tint = Color.White)
            }
            IconButton(
                onClick = {Toast.makeText(context,"Search",Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
            }
            IconButton(
                onClick = {Toast.makeText(context,"More",Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More", tint = Color.White)
            }
        })
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnNavDrawer(){
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Box(modifier = Modifier.background(Green).fillMaxWidth().height(150.dp))

                Divider()
                NavigationDrawerItem(label = { Text(text = "Home", color = Green) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "home",
                            tint = Color.White
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Home.screen) {
                            popUpTo(0)
                        }
                    })

                NavigationDrawerItem(label = { Text(text = "Profile", color = Green) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "profile",
                            tint = Color.White
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.screen) {
                            popUpTo(0)
                        }
                    })

                NavigationDrawerItem(label = { Text(text = "Settings", color = Green) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "settings",
                            tint = Color.White
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Settings.screen) {
                            popUpTo(0)
                        }
                    })

                NavigationDrawerItem(label = { Text(text = "Logout", color = Green) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "logout",
                            tint = Color.White
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                    })
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(title = { Text(text = "WhatsApp") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Green,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Rounded.Menu, contentDescription = "MenuButton")
                        }
                    })
            }
        ) {
            NavHost(navController = navigationController,
                startDestination = Screens.Home.screen){
                composable(Screens.Home.screen) { Home()  }
                composable(Screens.Profile.screen){ Profile() }
                composable(Screens.Settings.screen){ Settings() }
            }
        }
    }
}

@Preview
@Composable
fun LearnPreview(){
    LearnJetpackTheme {
        LearnNavDrawer()
    }
}

@Composable
fun MyBottomAppBar(){
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Filled.Home)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = Green) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Filled.Home
                        navigationController.navigate(Screens2.Home.screens){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Filled.Home, contentDescription = "Home", modifier = Modifier,
                        tint = if (selected.value == Icons.Filled.Home ) Color.White else Color.Gray)
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Filled.Search
                        navigationController.navigate(Screens2.Search.screens){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Filled.Search, contentDescription = "Home", modifier = Modifier,
                        tint = if (selected.value == Icons.Filled.Search ) Color.White else Color.Gray)
                }

                Box(modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                    contentAlignment = Alignment.Center) {
                    FloatingActionButton(onClick = {Toast.makeText(context,"Touch",Toast.LENGTH_SHORT).show()}) {
                        Icon(Icons.Default.Add, contentDescription = null, tint = Green)
                    }
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Filled.Notifications
                        navigationController.navigate(Screens2.Notification.screens){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Filled.Notifications, contentDescription = "Notification", modifier = Modifier,
                        tint = if (selected.value == Icons.Filled.Notifications ) Color.White else Color.Gray)
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Filled.Person
                        navigationController.navigate(Screens2.Profile .screens){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Filled.Person, contentDescription = "profile", modifier = Modifier,
                        tint = if (selected.value == Icons.Filled.Person ) Color.White else Color.Gray)
                }
            }
        }
    ) {paddingValues ->
        NavHost(navController = navigationController,
            startDestination = Screens2.Home.screens,
            modifier = Modifier.padding(paddingValues)){
            composable(Screens2.Home.screens) { Home2() }
            composable(Screens2.Search.screens) { Search2() }
            composable(Screens2.Notification.screens) { Notification2() }
            composable(Screens2.Profile.screens) { Profile2() }

        }
    }
}

@Preview
@Composable
fun PreviewBottomNav(){
    LearnJetpackTheme {
        MyBottomAppBar()
    }
}