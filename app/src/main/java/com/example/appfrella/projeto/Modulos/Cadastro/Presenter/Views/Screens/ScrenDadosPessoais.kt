package com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Views.Screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Views.dialogs.DialogUF
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel.ActCadastroViewModel
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel.ScrenDadosEnderecoViewModel
import com.example.appfrella.projeto.Utils.ValidarCampos.Companion.isIdadeValida
import com.example.appfrella.projeto.Utils.ValidarCampos.Companion.removerNaoNumericos
import com.example.appfrella.projeto.UtisViews.Mascaras.MascaraCelular
import com.example.appfrella.projeto.UtisViews.Mascaras.MascaraCep
import com.example.appfrella.projeto.UtisViews.Mascaras.MascaraData
import com.example.appfrella.projeto.UtisViews.ProgressBarCentralizao
import com.example.appfrella.projeto.UtisViews.componetes.Botao.Botao
import com.example.appfrella.projeto.UtisViews.componetes.Input.InputNumeroComum
import com.example.appfrella.projeto.UtisViews.componetes.Input.InputTextComum
import com.example.appfrella.projeto.UtisViews.componetes.Text.TextSelect
import com.example.appfrella.projeto.UtisViews.dialogs.DialogErro


@Composable
fun ScreenDadosPessoais(
    viewModel: ScrenDadosEnderecoViewModel?,
    viewModelActCadastro: ActCadastroViewModel?
) {
    val stateScroll = rememberScrollState()
    val context = LocalContext.current
    var textNome by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textDataNascimento by remember { mutableStateOf("") }
    var textCelular by remember { mutableStateOf("") }
    var textoCep by remember { mutableStateOf("") }
    var textoLogradouro by remember { mutableStateOf("") }
    var textoBairro by remember { mutableStateOf("") }
    var textoComplemento by remember { mutableStateOf("") }
    val mostrarModal = remember { mutableStateOf(false) }
    val mostrarDialogErro = remember { mutableStateOf(false) }
    val mostrarProgress = remember { mutableStateOf(false) }
    val focusNome = remember { FocusRequester() }
    val focusEmail = remember { FocusRequester() }
    val focusLogradouro = remember { FocusRequester() }
    val focusBairro = remember { FocusRequester() }
    val focusComplemento = remember { FocusRequester() }
    val emRequest = remember { mutableStateOf(false) }
    val textCidade = remember { mutableStateOf("") }
    val erro = viewModel?.erro!!.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(stateScroll)
        ) {


            viewModel.atualizarListaUF()

            val ufSelecionado = viewModel.ufSelecionado.collectAsState().value

            viewModel.atualizarListaUF()

            val listaUF = viewModel.listaUF.collectAsState(emptyList()).value


            Spacer(Modifier.height(32.dp))
            InputTextComum(
                text = textNome,
                "Nome Completo",
                "nome completo",
                onTextChange = { textNome = it },
                error = textNome.length in 1..3,
                focusRequester = focusNome
            )

            InputNumeroComum(
                text = textDataNascimento,
                onTextChange = { textDataNascimento = it },
                mascara = MascaraData(),
                maximoLetras = 8,
                titulo = "Data de Nascimento",
                placeHolder = "dd/mm/aaaa",
                error = textDataNascimento.length in 1..7
            )


            InputTextComum(
                text = textEmail,
                "exemplo@email.com",
                "Email",
                onTextChange = { textEmail = it },
                error = !android.util.Patterns.EMAIL_ADDRESS.matcher(textEmail)
                    .matches() && textEmail.length > 1,
                focusRequester = focusEmail
            )

            InputNumeroComum(
                text = textCelular,
                onTextChange = { textCelular = it },
                mascara = MascaraCelular(),
                maximoLetras = 11,
                titulo = "Celular",
                placeHolder = "00 00000-0000",
                error = textCelular.length in 1..10
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
                error = textoLogradouro.length in 1..4,
                focusRequester = focusLogradouro
            )

            InputTextComum(
                textoBairro,
                onTextChange = { textoBairro = it },
                titulo = "Bairro",
                placeHolder = "Ex : bairro ruaa..",
                error = textoLogradouro.length in 1..4,
                focusRequester = focusBairro
            )

            InputTextComum(
                textoComplemento,
                onTextChange = { textoComplemento = it },
                titulo = "Complemento",
                placeHolder = "Ex : Casa..",
                error = textoLogradouro.length in 1..4,
                focusRequester = focusComplemento
            )
            TextSelect("Estado", ufSelecionado) {
                mostrarModal.value = true


            }

            TextSelect("Cidade", "Cidade") {

            }

            Botao("Continuar") {
                viewModelActCadastro!!.atualizarTituloCabecario("Dados Pessoais")
                if (textNome.length >= 3 &&
                    android.util.Patterns.EMAIL_ADDRESS.matcher(textEmail).matches() &&
                    textDataNascimento.length == 10 &&
                    textDataNascimento.isIdadeValida() &&
                    textCelular.removerNaoNumericos().length >= 11 &&
                    textoCep.removerNaoNumericos().length > 9 &&
                    textoLogradouro.length >= 3 &&
                    textoBairro.length >= 3 &&
                    ufSelecionado.isNotEmpty()
                ) {


                } else {
                    Toast.makeText(
                        context,
                        "Preencha todos os campos vazios ou marcados",
                        Toast.LENGTH_LONG
                    ).show()
                    viewModel.atualizaMensagemErro("Preencha a da de nascismentos")


                }

            }

            if (textoCep.length == 8) {
                mostrarProgress.value = true
                viewModel.buscarDadosCEP(textoCep)

            }

            if (erro.value != "") {
                DialogErro(
                    primaryAction = { mostrarDialogErro.value = false },
                    erro.value
                )
            }
            if (mostrarModal.value) {
                DialogUF(
                    primaryAction = { mostrarModal.value = false },
                    listUF = listaUF,
                    viewModel
                )
            }
        }

        ProgressBarCentralizao(mostrarProgress.value)

    }

    viewModel.cep.collectAsState().value.let { cep ->
        emRequest.value = false
        mostrarProgress.value = false
        if(cep.uf.isNotEmpty()){
            textoLogradouro = cep.logradouro
            textoBairro = cep.bairro
            textoComplemento = cep.complemento
            viewModel.atualizarUfSelecionado(cep.uf)
        }

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenDadosPessoaisPreview() {
    ScreenDadosPessoais(null, viewModelActCadastro = null)
}