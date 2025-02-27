package com.example.appfrella.Presenter.View.cadastro.Atividades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appfrella.Presenter.View.cadastro.Atividades.Screens.ScreenEnderecoPessoal
import com.example.appfrella.Presenter.View.cadastro.Atividades.theme.AppFrellaTheme
import com.example.appfrella.Presenter.View.cadastro.componetes.Topo.TopoCadstro
import com.example.appfrella.Utis.Constantes

class ActCadastro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFrellaTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        TopoCadstro(Constantes.dadosEndereco) {
            navController.popBackStack()
        }
        NavHost(
            navController = navController,
            startDestination = "enderecoPessoal"
        ) {
            composable("enderecoPessoal") {
                ScreenEnderecoPessoal()
            }
            //navController.navigate("enderecoPessoal") // para ir para outra tela
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppFrellaTheme {
        AppNavigation()
    }
}