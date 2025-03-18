package com.example.appfrella.projeto.Modulos.Inicial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.copy
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appfrella.R
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Views.Atividades.ActCadastro
import com.example.appfrella.projeto.Modulos.Inicial.ui.theme.AppFrellaTheme
import com.example.appfrella.projeto.UtisViews.componetes.Botao.BotaoBordaBranca
import com.example.appfrella.projeto.UtisViews.componetes.Botao.BotaoBranco
import com.example.appfrella.projeto.UtisViews.componetes.Text.TextDescricaoCompose
import com.example.appfrella.projeto.UtisViews.componetes.Text.TextTiTuloInfo

class ActTelaInicial : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFrellaTheme {
                Inicial(this)
            }
        }
    }
}

@Composable
fun Inicial(
    context: Context?
) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter =  painterResource(R.drawable.imagemfunndo),
            contentDescription = "imagem de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale =  ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color(0xFF1C34CE).copy(alpha = 0.3f),
                            Color(0xFF1C34CE).copy(alpha = 0.8f),
                            Color(0xFF1C34CE).copy(alpha = 0.9f),
                            Color(0xFF1C34CE),
                            Color(0xFF1C34CE)
                        )
                    )
                )
        )

        Column (
            modifier = Modifier.fillMaxSize().padding(start = 24.dp, end = 24.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            TextTiTuloInfo()
            Spacer(modifier = Modifier.height(8.dp))
            TextDescricaoCompose()
            Spacer(modifier = Modifier.height(28.dp))
            BotaoBranco() {


            }
            Spacer(modifier = Modifier.height(12.dp))
            BotaoBordaBranca(){
                val intent = Intent(context, ActCadastro::class.java)
                context?.startActivity(intent)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    Inicial (null)
}