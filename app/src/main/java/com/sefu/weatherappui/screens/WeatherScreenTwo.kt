package com.sefu.weatherappui.screens

import android.graphics.BlurMaskFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sefu.weatherappui.R
import com.sefu.weatherappui.WeatherContent
import com.sefu.weatherappui.ui.theme.WeatherAppUiTheme
import kotlinx.coroutines.CoroutineStart

@Composable
fun WeatherScreenTwo(modifier: Modifier=Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.color_1))) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(38.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(50.dp)) {
            TopBar()
            LocationContent()
            WeatherBody(name = "28°")
                WeatherItems()
            IconBar()
        }

    }

}

@Composable
fun TopBar(modifier: Modifier=Modifier) {
    Row(modifier=modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Box(contentAlignment = Alignment.Center,modifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp))
            .size(60.dp)
            .background(color = Color.Gray.copy(0.3F))) {
            Icon(Icons.Outlined.Menu, contentDescription ="Menu", tint = Color.White )

        }
        Box(contentAlignment = Alignment.Center,modifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp))
            .size(60.dp)
            .background(color = Color.Gray.copy(0.3F))){
Icon(Icons.Outlined.Settings, contentDescription ="settings",tint = Color.White  )
        }
    }

}

@Composable
fun LocationContent(modifier: Modifier=Modifier) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "Badakhshan", fontSize = 36.sp ,style= TextStyle(color = Color.White))
        Text(text = "Chance of Rain: 15%",fontSize = 24.sp ,style = TextStyle(color = Color.White))}}

@Composable
    fun WeatherBody(name:String,modifier: Modifier=Modifier) {
        Box(modifier = modifier.size(width=150.dp, height =300.dp ),contentAlignment = Alignment.TopCenter ) {

Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {


    val paint = Paint().asFrameworkPaint()

    val gradientShader: Shader = LinearGradientShader(
        from = Offset(0f, 0f),
        to = Offset(0f, 400f),
        listOf(Color.White, Color.Gray)
    )

    Canvas(modifier.fillMaxWidth()) {
        paint.apply {
            isAntiAlias = true
            textSize = 200f
            style = android.graphics.Paint.Style.FILL
//                        typeface = Typeface.create(CoroutineStart.DEFAULT, Typeface.BOLD)
            color = android.graphics.Color.parseColor("#cdcdcd")
            xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
            maskFilter = BlurMaskFilter(30f, BlurMaskFilter.Blur.NORMAL)
        }
        drawIntoCanvas { canvas ->
            canvas.save()
            canvas.nativeCanvas.translate(2f, 5f)
            canvas.nativeCanvas.drawText(name, 0f, 400f, paint)
            canvas.restore()
            paint.shader = gradientShader
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            paint.maskFilter = null
            canvas.nativeCanvas.drawText(name, 0f, 400f, paint)
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
            canvas.nativeCanvas.drawText(name, 0f, 400f, paint)
        }
        paint.reset()
    }

    Image(
        painter = painterResource(id = R.drawable.cloudy),
        contentDescription = null,
        modifier = Modifier.size(100.dp),
    )
}


        }

    }

@Composable
fun WeatherItems(modifier: Modifier=Modifier) {
Row(modifier=modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Image(painter = painterResource(id = R.drawable.calm), modifier = Modifier.size(40.dp), contentDescription = null)
        Text(text = "2:00 am",style = TextStyle(color = Color.LightGray))
        Text(text ="32°",fontSize = 20.sp, fontWeight = FontWeight.Bold,style = TextStyle(color = Color.White) )
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Image(painter = painterResource(id = R.drawable.cloudy), modifier = Modifier.size(40.dp),  contentDescription = null)
        Text(text = "2:00 am",style = TextStyle(color = Color.LightGray))
        Text(text ="30°",fontSize = 20.sp, fontWeight = FontWeight.Bold, style = TextStyle(color = Color.White))
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Image(painter = painterResource(id = R.drawable.thunder), modifier = Modifier.size(40.dp),  contentDescription = null)
        Text(text = "2:00 am", style = TextStyle(color = Color.LightGray))
        Text(text ="29°", fontSize = 20.sp, fontWeight = FontWeight.Bold,style = TextStyle(color = Color.White) )
    }

}
}

@Composable
fun IconBar() {

}


@Preview(showBackground = true)
@Composable
fun PreviewWeatherScreenTwo() {
WeatherAppUiTheme {
    WeatherScreenTwo()
}
}

@Preview
@Composable
fun PreviewTopBar() {
    WeatherAppUiTheme {
        TopBar()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLocationContent() {
    WeatherAppUiTheme {
        LocationContent()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherBody() {
    WeatherAppUiTheme {
WeatherBody(name = "28°")
    }
}

@Preview
@Composable
fun PreviewWeatherItems() {
    WeatherAppUiTheme {
        WeatherItems()
    }
}

@Preview
@Composable
fun PreviewIconBar() {
    WeatherAppUiTheme {
        IconBar()
    }
}