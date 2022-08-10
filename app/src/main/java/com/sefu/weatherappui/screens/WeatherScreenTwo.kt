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
    Box(modifier = modifier.fillMaxSize()) {
        TopBar()

//        LocationContent(name = "")
    }

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

@Composable
fun LocationContent(modifier: Modifier=Modifier) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "Badakshan", fontSize = 30.sp, )
        Text(text = "Chance of Rain: 15%",style = TextStyle(color = Color.Gray))}}

    @Composable
    fun WeatherBody(name:String,modifier: Modifier=Modifier) {
        Box(contentAlignment = Alignment.TopCenter,modifier = modifier.fillMaxWidth()) {

            Box(modifier = Modifier
                .size(height=100.dp,width=200.dp)
                .padding(), contentAlignment = Alignment.TopCenter) {

                val paint = Paint().asFrameworkPaint()

                val gradientShader: Shader = LinearGradientShader(
                    from = Offset(0f, 0f),
                    to = Offset(0f, 400f),
                    listOf(Color.White, Color.Gray)
                )

                Canvas(modifier.fillMaxWidth()) {
                    paint.apply {
                        isAntiAlias = true
                        textSize = 400f
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
            }
            Box(modifier = Modifier
                .padding(end = 36.dp)
                .size(height = 250.dp, width = 250.dp), contentAlignment = Alignment.BottomCenter) {
                Image(painter = painterResource(id = R.drawable.cloudy), contentDescription =null, modifier = Modifier.size(150.dp), )
            }

        }

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
