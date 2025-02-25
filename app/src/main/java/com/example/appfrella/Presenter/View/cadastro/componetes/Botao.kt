package com.example.appfrella.Presenter.View.cadastro.componetes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Botao(function: () -> Unit)  {

    Button(onClick = {
        function()
    }, modifier = Modifier.fillMaxWidth()
        .padding(start = 8.dp, top = 48.dp, end = 8.dp, bottom = 8.dp)
        .height(48.dp)
        .background(Color(0xFF304FFE), shape = RoundedCornerShape(size = 10.dp)),
        colors = ButtonDefaults.buttonColors(
            Color(0xFF304FFE),
            contentColor = Color.White
        )


    ) {
        Row (Modifier.fillMaxWidth()){
            Text(text = "Entrar",
                textAlign = TextAlign.Start)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun BotaoPreview() {
     Botao(){

     }
}