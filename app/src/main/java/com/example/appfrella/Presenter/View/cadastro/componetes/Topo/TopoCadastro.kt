package com.example.appfrella.Presenter.View.cadastro.componetes.Topo

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appfrella.R


@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun TopoCadstro(titulo:String, funcao : () -> Unit){

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(122.dp)
            .background(Color(0xFFFFF))
            .padding(0.dp)
            .shadow(
                elevation = 2.dp,
                shape = RectangleShape,
                ambientColor = Color.Black.copy(alpha = 0.2f),
                spotColor = Color.Black.copy(alpha = 0.2f)
            )
            .padding( top = 52.dp, bottom = 32.dp),
             verticalAlignment = Alignment.CenterVertically )
    {
        Image(
            modifier = Modifier.padding(start = 24.dp)
                .size(24.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ){
                    funcao()
                },

            painter = painterResource(id = R.drawable.voltar_tela),
            contentDescription = null
        )
        Text(
            text = titulo,
            modifier = Modifier.fillMaxWidth().padding(end = 24.dp),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.manrope, FontWeight.Normal)),
                letterSpacing = 0.15.sp,
            )
        )
    }


}

@Preview (showBackground = true)
@Composable
fun TopoCadstroPreview(){
    TopoCadstro("Cadastro"){

    }
}
