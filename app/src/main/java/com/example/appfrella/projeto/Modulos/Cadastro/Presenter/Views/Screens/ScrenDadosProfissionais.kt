package com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Views.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.appfrella.R
import com.example.appfrella.projeto.UtisViews.componetes.Input.InputTextComum
import com.example.appfrella.projeto.UtisViews.componetes.Text.TextSelect


@Composable
fun SrenDadosProfissionais() {
    val stateScroll = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(stateScroll)
                .background(color = Color.White)
        ) {
            Spacer(Modifier.height(32.dp))
            var text by remember { mutableStateOf("") }
            var textRegiao by remember { mutableStateOf("") }

            InputTextComum(
                text = text,
                placeHolder = "descreva sua profissão...",
                titulo = "Profissão",
                onTextChange = { text = it },
                error = false,
                focusRequester = FocusRequester()
            )

            InputTextComum(
                text = textRegiao,
                placeHolder = "descreva região de atuação...",
                titulo = "Area atuaçao",
                onTextChange = { textRegiao = it },
                error = false,
                focusRequester = FocusRequester()
            )

            TextSelect(
                titulo = "Disponibilidade",
                slecionado = "Selecione sua disponibilidade..."
            ) {}
        }

        Button(onClick = {
            {}
        }, modifier = Modifier.fillMaxWidth()
            .padding(start = 24.dp, top = 48.dp, end = 24.dp, bottom = 56.dp)
            .height(56.dp)
            .align(Alignment.BottomCenter)
            .background(Color(0xFF374BFF), shape = RoundedCornerShape(size = 10.dp)),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF374BFF),
                contentColor = Color.White
            )


        ) {
            Row (Modifier.fillMaxWidth()){
                Text(text = "Continuar",
                    modifier = Modifier.weight(1f).padding(top = 2.dp),
                    style =  TextStyle(
                        fontFamily = FontFamily(Font(R.font.manrope))

                    )
                )
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(
                        ){},
                    painter = painterResource(id = R.drawable.seta_direita),
                    contentDescription = null
                )
            }
        }

    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SrenDadosProfissionaisPreview() {
    SrenDadosProfissionais()
}