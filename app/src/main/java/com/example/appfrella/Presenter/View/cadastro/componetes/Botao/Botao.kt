package com.example.appfrella.Presenter.View.cadastro.componetes.Botao

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun Botao(nome: String = "continuar",function:() -> Unit)  {

    Button(onClick = {
        function()
    }, modifier = Modifier.fillMaxWidth()
        .padding(start = 24.dp, top = 48.dp, end = 24.dp, bottom = 56.dp)
        .height(56.dp)
        .background(Color(0xFF374BFF), shape = RoundedCornerShape(size = 10.dp))
        ,
        colors = ButtonDefaults.buttonColors(
            Color(0xFF374BFF),
            contentColor = Color.White
        )


    ) {
        Row (Modifier.fillMaxWidth()){
            Text(text = nome,
                modifier = Modifier.weight(1f).padding(top = 2.dp),
                style =  TextStyle(
                    fontFamily = FontFamily(Font(R.font.manrope))

                )
            )
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ){},
                painter = painterResource(id = R.drawable.seta_direita),
                contentDescription = null
            )
        }
    }

}

@Composable
fun BotaoErro(function: () -> Unit){
    Button(
        onClick = { function() },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 48.dp, top = 52.dp, end = 48.dp, bottom = 68.dp)
            .background(color = Color(0xFFF15249), shape = RoundedCornerShape(size = 10.dp)),
        colors = ButtonDefaults.buttonColors(
            Color(0xFFF15249),
            contentColor = Color.White
        )


    ) {
        Row (
            modifier =  Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Fechar",
                modifier = Modifier.padding(top = 1.dp),
                style =  TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.manrope)),

                )
                )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BotaoPreview() {
     Botao(){

     }
}

@Preview
@Composable
fun BotaoErroPreview() {
    BotaoErro(){

    }
}