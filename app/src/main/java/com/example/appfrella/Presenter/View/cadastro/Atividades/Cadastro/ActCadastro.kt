package com.example.appfrella.Presenter.View.cadastro.Atividades.Cadastro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appfrella.Presenter.View.cadastro.Atividades.Cadastro.Screens.ScreenDadosPessoais
import com.example.appfrella.Presenter.View.cadastro.Atividades.Cadastro.Screens.SrenDadosProfissionais
import com.example.appfrella.Presenter.View.cadastro.Atividades.Cadastro.theme.AppFrellaTheme
import com.example.appfrella.Presenter.View.cadastro.componetes.Topo.TopoCadstro
import com.example.appfrella.Presenter.ViewModel.Factory.ActCadastroViewModel
import com.example.appfrella.Presenter.ViewModel.Factory.ActCadastroViewModelFactory
import com.example.appfrella.Presenter.ViewModel.Factory.ScrenDadosEnderecoViewModel
import com.example.appfrella.Presenter.ViewModel.Factory.ScrrenDadosEnderecoPessoalFactory
import com.example.appfrella.Utis.Constantes

class ActCadastro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val factory = ScrrenDadosEnderecoPessoalFactory()
        val viewModelFactory = ActCadastroViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(ScrenDadosEnderecoViewModel::class.java)
        val viewModelCadastro = ViewModelProvider(this, viewModelFactory).get(ActCadastroViewModel::class.java)
        setContent {

            AppFrellaTheme {

                AppNavigation(viewModel, viewModelCadastro
                )
            }
        }
    }
}

@Composable
fun AppNavigation(viewModel: ScrenDadosEnderecoViewModel?, viewModelActCadastro: ActCadastroViewModel?) {
    val navController = rememberNavController()
    val tituloCabecario = viewModelActCadastro?.tituloCabecario?.collectAsState()?.value ?: "Dados Pessoais"


    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        TopoCadstro(tituloCabecario) {
            navController.popBackStack()
        }
        NavHost(
            navController = navController,
            startDestination = "dadosPessoais"
        ) {
            composable("dadosProfissionais") {
                SrenDadosProfissionais()
            }
            composable("dadosPessoais"){
                ScreenDadosPessoais(viewModel, viewModelActCadastro)
            }
          //  navController.navigate("dadosPessoais") // pra ir para a tela de dados pessoais
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppFrellaTheme {
        AppNavigation( null, null)
    }
}