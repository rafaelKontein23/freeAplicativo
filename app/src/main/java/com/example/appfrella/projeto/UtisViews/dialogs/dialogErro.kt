package com.example.appfrella.projeto.UtisViews.dialogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.appfrella.R
import com.example.appfrella.projeto.UtisViews.componetes.Botao.BotaoErro
import com.example.appfrella.projeto.UtisViews.componetes.Text.TextDescricao
import com.example.appfrella.projeto.UtisViews.componetes.Text.TextModal

@Composable
fun DialogErro(
    mostrarDialog: Boolean,
    primaryAction: () -> Unit,
    textDescricao: String = "Isso é um erro, e acontece. Tente novamente mais tarde"
) {
    if (mostrarDialog) {
        Dialog(
            onDismissRequest = {
                primaryAction()
            },
            properties = DialogProperties(
                dismissOnClickOutside = true,
                usePlatformDefaultWidth = false
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .wrapContentHeight()
                    .background(Color.White, shape = RoundedCornerShape(8.dp)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(52.dp))
                Image(
                    painter = painterResource(R.drawable.cancelar),
                    contentDescription = "Fechar",
                    modifier = Modifier
                        .size(68.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                )
                TextModal("Opss!!")
                TextDescricao(textDescricao)
                BotaoErro {
                    primaryAction()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogErroPreview() {
    DialogErro(mostrarDialog = false, primaryAction = {}, textDescricao = "Erro de rede")
}