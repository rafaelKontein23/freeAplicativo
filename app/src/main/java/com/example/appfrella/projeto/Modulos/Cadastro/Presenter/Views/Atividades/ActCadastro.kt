package com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Views.Atividades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Factory.ActCadastroViewModelFactory
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Factory.ScrenDadosBancariosFactory
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Factory.ScrrenDadosEnderecoPessoalFactory
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Views.Screens.ScreenDadosPessoais
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Views.Screens.ScrenDadosRecebimento
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Views.Screens.SrenDadosProfissionais
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel.ActCadastroViewModel
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel.ScrenDadosBancariosViewModel
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel.ScrenDadosEnderecoViewModel
import com.example.appfrella.projeto.UtisViews.componetes.Topo.TopoCadstro
import com.example.appfrella.projeto.theme.AppFrellaTheme


class ActCadastro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val factory = ScrrenDadosEnderecoPessoalFactory(this)
        val viewModelFactory = ActCadastroViewModelFactory()
        val viewModelFactoryRecebimento  = ScrenDadosBancariosFactory(this)

        val viewModel = ViewModelProvider(this, factory).get(ScrenDadosEnderecoViewModel::class.java)
        val viewModelCadastro = ViewModelProvider(this, viewModelFactory).get(ActCadastroViewModel::class.java)
        val viewModelRecebimento = ViewModelProvider(this, viewModelFactoryRecebimento).get(ScrenDadosBancariosViewModel::class.java)

        setContent {

            AppFrellaTheme {

                AppNavigation(viewModel, viewModelCadastro, viewModelRecebimento
                )
            }
        }
    }
}

@Composable
fun AppNavigation(viewModel: ScrenDadosEnderecoViewModel?, viewModelActCadastro: ActCadastroViewModel?, viewModelRecebimento: ScrenDadosBancariosViewModel? = null) {
    val navController = rememberNavController()
    val tituloCabecario = viewModelActCadastro?.tituloCabecario?.collectAsState()?.value ?: ""
    val proximaTela = viewModelActCadastro?.proximaTela?.collectAsState()?.value ?: ""

    LaunchedEffect(proximaTela) {
        if (proximaTela.isNotEmpty()) {
            navController.navigate(proximaTela)
            viewModelActCadastro?.resetaTela()
        }
    }


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
                SrenDadosProfissionais(viewModelActCadastro)
            }
            composable("dadosPessoais"){
                ScreenDadosPessoais(viewModel, viewModelActCadastro)
            }
            composable("dadosRecebimentos") {
                ScrenDadosRecebimento(viewModelRecebimento)
            }

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