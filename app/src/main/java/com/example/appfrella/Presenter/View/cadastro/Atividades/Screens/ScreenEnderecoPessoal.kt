package com.example.appfrella.Presenter.View.cadastro.Atividades.Screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appfrella.Presenter.View.cadastro.componetes.Topo.TopoCadstro
import com.example.appfrella.Utis.Constantes


@Composable
fun ScreenEnderecoPessoal(){
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color(0xFFFFFFFF))
    ) {
        // Conteúdo da tela de endereço pessoal
        Text(text = "Conteúdo da Tela de Endereço Pessoal")

    }



}

@Preview(showBackground = true, showSystemUi = true, uiMode =UI_MODE_NIGHT_YES)
@Composable
fun ScreenEnderecoPessoalPreview(){

    ScreenEnderecoPessoal()
}