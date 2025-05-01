package com.example.learnjetpack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.learnjetpack.ui.theme.Green

@Composable
fun Home(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center).fillMaxSize()) {
            Text(text = "Home", fontSize = 30.sp, color = Green)
        }
    }
}

@Composable
@Preview
fun HomePreview(){
    Home()
}