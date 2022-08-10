package com.sefu.weatherappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sefu.weatherappui.ui.theme.WeatherAppUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppUiTheme {
                MainScreen()

            }
        }
    }
}

@androidx.compose.runtime.Composable
fun MainScreen(modifier: Modifier=Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .background(color = Color.White.copy(1F))) {

    }
Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(40.dp),modifier = Modifier
    .fillMaxSize()
    .padding(horizontal = 50.dp, vertical = 40.dp)){
    TopBar()
    WeatherContent()
}
}
@androidx.compose.runtime.Composable
fun TopBar(modifier: Modifier=Modifier) {
    Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Center,modifier=modifier.fillMaxWidth()) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .size(width = 80.dp, height = 40.dp)
                .background(color = Color.Gray.copy(0.2F))
        ) {
            Text(text = "skip")
        }
    }

}

@Composable
fun WeatherContent(modifier: Modifier=Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(20.dp),modifier = modifier.fillMaxWidth()) {



        Card(elevation = 24.dp, shape = RoundedCornerShape(16.dp)) {
                  Image(painter = painterResource(id = R.drawable.icon1), alignment = Alignment.Center, contentDescription = "", modifier = Modifier
                      .clip(shape = RoundedCornerShape(12.dp))
                  )

        }



        Text(text = "Weather Application", fontSize = 40.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, style= TextStyle(
            colorResource(id = R.color.color_1)) )
        Text(text = "Get to know your weather maps and climate preception forecast", textAlign = TextAlign.Center, fontSize = 20.sp,style = TextStyle(color = Color.Gray))

        Spacer(modifier = Modifier.height(30.dp))

Card(elevation = 24.dp, shape = RoundedCornerShape(16.dp)) {
    Box(contentAlignment = Alignment.Center,modifier = Modifier
        .clip(shape = RoundedCornerShape(12.dp))
        .size(width = 250.dp, height = 50.dp)
        .background(colorResource(id = R.color.color_2))) {
        Text(text ="Get Started", fontSize = 24.sp )
    }
}

    }
}

@Preview
@Composable
fun MainScreenPreview() {
    WeatherAppUiTheme {
        MainScreen()
    }
}

@Preview
@Composable
fun TopBarPreview() {
    WeatherAppUiTheme {
        TopBar()
    }
}

@Preview
@Composable
fun WeatherContentPreview() {
    WeatherAppUiTheme {
        WeatherContent()
    }
}