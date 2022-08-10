package com.sefu.weatherappui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sefu.weatherappui.WeatherContent
import com.sefu.weatherappui.ui.theme.WeatherAppUiTheme

@Composable
fun WeatherScreenTwo() {

}

@Composable
fun TopBar(modifier: Modifier=Modifier) {
    Row(modifier=modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Box(contentAlignment = Alignment.Center,modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .size(40.dp)
            .background(color = Color.Gray.copy(0.3F))) {
            Icon(Icons.Outlined.Menu, contentDescription ="Menu" )

        }
        Box(contentAlignment = Alignment.Center,modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .size(40.dp)
            .background(color = Color.Gray.copy(0.3F))){
Icon(Icons.Outlined.Settings, contentDescription ="settings" )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewWeatherScreenTwo() {
WeatherAppUiTheme {
    TopBar()
}
}

@Preview
@Composable
fun PreviewTopBar() {
    WeatherAppUiTheme {
        TopBar()
    }
}