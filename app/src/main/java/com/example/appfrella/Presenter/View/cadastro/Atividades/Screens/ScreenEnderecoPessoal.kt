package com.example.appfrella.Presenter.View.cadastro.Atividades.Screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appfrella.Presenter.View.cadastro.componetes.Botao.Botao
import com.example.appfrella.Presenter.View.cadastro.componetes.Input.InputNumeroComum
import com.example.appfrella.Presenter.View.cadastro.componetes.Input.InputTextComum
import com.example.appfrella.Presenter.View.cadastro.componetes.Text.TextSelect
import com.example.appfrella.Presenter.View.cadastro.componetes.Utils.Mascaras.MascaraCep
import com.example.appfrella.Presenter.View.cadastro.dialogCadastro.DialogUF
import com.example.appfrella.Presenter.ViewModel.Factory.ScrenDadosEnderecoViewModel


@Composable
fun ScreenEnderecoPessoal(viewModel: ScrenDadosEnderecoViewModel?) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color(0xFFFFFFFF))
    ) {
        Spacer(Modifier.height(48.dp))
        var textoCep by remember { mutableStateOf("") }
        var textoLogradouro by remember { mutableStateOf("") }
        var textoBairro by remember { mutableStateOf("") }
        var textoComplemento by remember { mutableStateOf("") }
        val mostrarModal =  remember { mutableStateOf(false) }
        viewModel?.atualizarListaUF()

        val listaUF = viewModel?.listaUF?.collectAsState(emptyList())?.value ?: emptyList() // aqui é o observe
        val ufSelecionado = viewModel?.ufSelecionado?.collectAsState()?.value ?: ""

        InputNumeroComum(
            textoCep,
            onTextChange = { textoCep = it },
            MascaraCep(),
            9,
            "CEP",
            "00000-000",
            textoCep.length in 1..7
        )
        InputTextComum(
            textoLogradouro,
            onTextChange = { textoLogradouro = it },
            titulo = "Logradouro",
            placeHolder = "Ex : Rua 123555..",
            error = textoLogradouro.length in 1..4
        )

        InputTextComum(
            textoBairro,
            onTextChange = { textoBairro = it },
            titulo = "Bairro",
            placeHolder = "Ex : bairro ruaa..",
            error = textoLogradouro.length in 1..4
        )

        InputTextComum(
            textoComplemento,
            onTextChange = { textoComplemento = it },
            titulo = "Complemento",
            placeHolder = "Ex : Casa..",
            error = textoLogradouro.length in 1..4
        )
        TextSelect("Estado",if(ufSelecionado.isEmpty()) "Estado" else ufSelecionado) {
            mostrarModal.value = true


        }

        TextSelect("Cidade","Cidade") {

        }

        Botao ("Continuar"){

        }

        if (mostrarModal.value) {
            DialogUF(
                primaryAction = { mostrarModal.value = false },
                listUF = listaUF,
                viewModel
            )
        }


    }


}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ScreenEnderecoPessoalPreview() {

    ScreenEnderecoPessoal(null)
}