package com.example.appfrella.Presenter.View.cadastro.Atividades.Cadastro.Screens

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
import com.example.appfrella.Presenter.View.cadastro.componetes.Utils.Mascaras.MascaraCelular
import com.example.appfrella.Presenter.View.cadastro.componetes.Utils.Mascaras.MascaraCep
import com.example.appfrella.Presenter.View.cadastro.componetes.Utils.Mascaras.MascaraData
import com.example.appfrella.Presenter.View.cadastro.dialogCadastro.DialogUF
import com.example.appfrella.Presenter.ViewModel.Factory.ScrenDadosEnderecoViewModel
import com.example.appfrella.Utis.extensoes.ValidarCampos.Companion.validaEmail


@Composable
fun ScreenDadosPessoais(viewModel: ScrenDadosEnderecoViewModel?){
    val stateScroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(stateScroll)
    ) {

        var textNome by remember { mutableStateOf("") }
        var textEmail by remember { mutableStateOf("") }
        var textDataNascimento by remember { mutableStateOf("") }
        var textCelular by remember { mutableStateOf("") }
        var textoCep by remember { mutableStateOf("") }
        var textoLogradouro by remember { mutableStateOf("") }
        var textoBairro by remember { mutableStateOf("") }
        var textoComplemento by remember { mutableStateOf("") }
        var mostrarModal =  remember { mutableStateOf(false) }

        viewModel?.atualizarListaUF()

        val listaUF = viewModel?.listaUF?.collectAsState(emptyList())?.value ?: emptyList() // aqui é o observe


        Spacer(Modifier.height(32.dp))
        InputTextComum(
            text = textNome,
            "Nome Completo",
            "nome completo",
            onTextChange = { textNome = it },
            error = textNome.length   in 1 ..  3
        )

        InputNumeroComum(
            text = textDataNascimento,
            onTextChange = { textDataNascimento = it },
            mascara = MascaraData(),
            maximoLetras = 8,
            titulo = "Data de Nascimento",
            placeHolder = "dd/mm/aaaa",
            error = textDataNascimento.length   in 1 ..  7
        )


        InputTextComum(
            text = textEmail,
            "exemplo@email.com",
            "Email",
            onTextChange = { textEmail = it },
            error = !android.util.Patterns.EMAIL_ADDRESS.matcher(textEmail).matches() && textEmail.length > 1
        )

        InputNumeroComum(
            text = textCelular,
            onTextChange = { textCelular = it },
            mascara = MascaraCelular(),
            maximoLetras = 11,
            titulo = "Celular",
            placeHolder = "00 00000-0000",
            error = textCelular.length   in 1 ..  10
        )


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
        TextSelect("Estado") {
            mostrarModal.value = true


        }

        TextSelect("Cidade") {

        }

        Botao ("Continuar"){

        }

        if (mostrarModal.value) {
            DialogUF(
                primaryAction = { mostrarModal.value = false },
                listUF = listaUF ,
            )
        }


    }
}


@Preview (showBackground = true, showSystemUi = true)
@Composable
fun ScreenDadosPessoaisPreview(){
    ScreenDadosPessoais(null)
}