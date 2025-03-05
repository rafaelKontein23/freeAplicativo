package com.example.appfrella.Presenter.View.cadastro.Atividades.Cadastro.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appfrella.Presenter.View.cadastro.componetes.Botao.Botao
import com.example.appfrella.Presenter.View.cadastro.componetes.Input.InputTextComum
import com.example.appfrella.Presenter.View.cadastro.componetes.Text.TextSelect


@Composable
fun SrenDadosProfissionais(){
    val stateScroll = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(stateScroll).background(color = Color.White)
    ) {
        Spacer(Modifier.height(32.dp))
        var text  by remember { mutableStateOf("") }
        var textRegiao  by remember { mutableStateOf("") }

        InputTextComum(
            text = text,
            placeHolder = "descreva sua profissão...",
            titulo = "Profissão",
            onTextChange = {text = it} ,
            error = false,
            focusRequester = FocusRequester()
        )

        InputTextComum(
            text = textRegiao,
            placeHolder = "descreva região de atuação...",
            titulo = "Area atuaçao",
            onTextChange = {textRegiao = it} ,
            error = false,
            focusRequester = FocusRequester()
        )

        TextSelect(
            titulo = "Disponibilidade",
            slecionado =  "Selecione sua disponibilidade..."
        ) {}
        Botao () {}
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SrenDadosProfissionaisPreview(){
    SrenDadosProfissionais()
}