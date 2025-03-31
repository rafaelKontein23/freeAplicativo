package com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Views.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Factory.ScrenDadosBancariosFactory
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Views.dialogs.DialogBanco
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel.ScrenDadosBancariosViewModel
import com.example.appfrella.projeto.UtisViews.ProgressBarCentralizao
import com.example.appfrella.projeto.UtisViews.componetes.Botao.BotaoSemModifer
import com.example.appfrella.projeto.UtisViews.componetes.Text.TextSelect
import com.example.appfrella.projeto.UtisViews.dialogs.DialogErro


@Composable
fun ScrenDadosRecebimento(
    viewModel: ScrenDadosBancariosViewModel?
) {
    viewModel?.buscarBanco()
    val bancoSelecionado by viewModel?.bancoSelecionado!!.collectAsState()
    val mostrarProgress = viewModel?.mostraProgress!!.collectAsState().value
    val mostraModalErro = viewModel?.mostraModalErro!!.collectAsState().value
    val mensagemErro = viewModel?.mensagemErro!!.collectAsState().value
    val mostraModalBanco = viewModel?.mostraBanco!!.collectAsState().value
    val listaBanco by viewModel?.listaBanco!!.collectAsState()
    Box {
        Column {
            Spacer(Modifier.height(32.dp))
            TextSelect("Banco", bancoSelecionado) {
                viewModel.mostraModalBanco(mostraModalBanco)
            }
        }
        BotaoSemModifer(
            Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 48.dp, end = 24.dp, bottom = 56.dp)
                .height(56.dp)
                .align(Alignment.BottomCenter)
                .background(Color(0xFF374BFF), shape = RoundedCornerShape(size = 10.dp))
        ) { }

        if (mostrarProgress) {
            ProgressBarCentralizao(mostrarProgress)
        }

        if (mostraModalBanco) {
            DialogBanco(
                primaryAction = { viewModel.mostraModalBanco(false) },
                listBanco = listaBanco,
                viewModel = viewModel
            )
        }
        if (mostraModalErro) {
            DialogErro(
                mostraModalErro,
                primaryAction = { viewModel.mostraModalErro(mensagemErro, false) },
                textDescricao = mensagemErro
            )
        }
    }
}


@Composable
@Preview
fun ScrenDadosRecebimentoPreview() {
    ScrenDadosRecebimento(null)
}