package com.example.appfrella.Presenter.View.cadastro.dialogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.appfrella.Presenter.View.cadastro.componetes.Input.InputTextBusca
import com.example.appfrella.Presenter.View.cadastro.componetes.Text.TextSelecao
import com.example.appfrella.Presenter.View.cadastro.componetes.Text.TextTituloDialog
import com.example.appfrella.Presenter.ViewModel.Factory.ScrenDadosEnderecoViewModel
import com.example.appfrella.R


@Composable
fun DialogUF(
    primaryAction: () -> Unit,
    listUF: List<String>,
    viewModel: ScrenDadosEnderecoViewModel?
) {
    Dialog(
        onDismissRequest = { primaryAction() },
        properties = DialogProperties(
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {
        var text by remember { mutableStateOf("") }

        viewModel?.filtraListaUF(text)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top =56.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                TextTituloDialog(
                    titulo = "Cidades"
                )

                Image(
                    painter = painterResource(R.drawable.x),
                    contentDescription = "Fechar ",
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .height(24.dp)
                        .size(24.dp).clickable {
                            primaryAction()
                        },
                )
            }

            InputTextBusca(
                text = text,
                onTextChange = { text = it }
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Faz a lista expandir dentro do diálogo
            ) {
                items(listUF) { item ->
                    TextSelecao(item, false){
                        viewModel?.atualizarUfSelecionado(item)
                        primaryAction()

                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun DialogCidadePreview() {
    DialogUF(primaryAction = {}, listUF = arrayListOf(), null)
}