package com.example.appfrella.Presenter.View.cadastro.Atividades.Cadastro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appfrella.Presenter.View.cadastro.Atividades.Cadastro.Screens.ScreenDadosPessoais
import com.example.appfrella.Presenter.View.cadastro.Atividades.Cadastro.Screens.ScreenEnderecoPessoal
import com.example.appfrella.Presenter.View.cadastro.Atividades.Cadastro.theme.AppFrellaTheme
import com.example.appfrella.Presenter.View.cadastro.componetes.Topo.TopoCadstro
import com.example.appfrella.Presenter.ViewModel.Factory.ScrenDadosEnderecoViewModel
import com.example.appfrella.Presenter.ViewModel.Factory.ScrrenDadosEnderecoPessoalFactory
import com.example.appfrella.Utis.Constantes

class ActCadastro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val factory = ScrrenDadosEnderecoPessoalFactory()
        val viewModel = ViewModelProvider(this, factory).get(ScrenDadosEnderecoViewModel::class.java)
        setContent {

            AppFrellaTheme {

                AppNavigation(viewModel)
            }
        }
    }
}

@Composable
fun AppNavigation(viewModel: ScrenDadosEnderecoViewModel?) {
    val navController = rememberNavController()

    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        TopoCadstro(Constantes.dadosEndereco) {
            navController.popBackStack()
        }
        NavHost(
            navController = navController,
            startDestination = "dadosPessoais"
        ) {
            composable("enderecoPessoal") {
                ScreenEnderecoPessoal(viewModel)
            }
            composable("dadosPessoais"){
                ScreenDadosPessoais(viewModel)
            }
            //navController.navigate("enderecoPessoal") // para ir para outra tela
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppFrellaTheme {
        AppNavigation( null)
    }
}