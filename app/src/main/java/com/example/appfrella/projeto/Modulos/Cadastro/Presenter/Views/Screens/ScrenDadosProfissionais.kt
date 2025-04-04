package com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Views.Screens

import android.widget.Toast
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel.ActCadastroViewModel
import com.example.appfrella.projeto.UtisViews.componetes.Botao.BotaoSemModifer
import com.example.appfrella.projeto.UtisViews.componetes.Input.InputTextComum


@Composable
fun SrenDadosProfissionais(
    viewModel: ActCadastroViewModel?

) {
    val context = LocalContext.current
    val stateScroll = rememberScrollState()
    var text by rememberSaveable { mutableStateOf("") }
    var textRegiao by rememberSaveable { mutableStateOf("") }
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

            InputTextComum(
                text = text,
                placeHolder = "descreva sua profissão...",
                titulo = "Profissão",
                onTextChange = { text = it },
                error = text.length in 1..2,
                focusRequester = FocusRequester()
            )

            InputTextComum(
                text = textRegiao,
                placeHolder = "descreva região de atuação...",
                titulo = "Area atuaçao",
                onTextChange = { textRegiao = it },
                error = textRegiao.length in 1..2,
                focusRequester = FocusRequester()
            )
        }

        BotaoSemModifer(
            Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 48.dp, end = 24.dp, bottom = 56.dp)
                .height(56.dp)
                .align(Alignment.BottomCenter)
                .background(Color(0xFF374BFF), shape = RoundedCornerShape(size = 10.dp))
        ) {
            if (
                text.length < 2 ||
                textRegiao.length < 2
            ) {
                Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                viewModel?.atualizarTituloCabecario("Dados Bancarios")

                viewModel?.navegaProximaTela("dadosRecebimentos")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SrenDadosProfissionaisPreview() {
    SrenDadosProfissionais(null)
}

