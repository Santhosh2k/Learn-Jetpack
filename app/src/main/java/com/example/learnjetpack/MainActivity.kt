package com.example.learnjetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.HorizontalAlignmentLine
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
import com.example.learnjetpack.ui.theme.LearnJetpackTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            LearnJetpackTheme {
                LearnButtonAndImage(modifier = Modifier.fillMaxSize())
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

    Box(modifier = Modifier.fillMaxSize().background(Color.Yellow), contentAlignment = Alignment.Center){
        Box(modifier = Modifier.height(IntrinsicSize.Min).width(300.dp).background(Color.Blue).clickable(onClick = clickBox), contentAlignment = Alignment.Center){
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