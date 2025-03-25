package com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ActCadastroViewModel : ViewModel() {
    private val _tituloCabecario = MutableStateFlow("Dados Pessoais")
    val tituloCabecario: StateFlow<String> = _tituloCabecario

    private val _proximaTela = MutableStateFlow("DadosPessoais")
    val proximaTela: StateFlow<String> = _proximaTela

    fun atualizarTituloCabecario(novoTitulo: String) {
        _tituloCabecario.value = novoTitulo
    }

    fun navegaProximaTela(novaTela: String){
        _proximaTela.value = novaTela
    }
}