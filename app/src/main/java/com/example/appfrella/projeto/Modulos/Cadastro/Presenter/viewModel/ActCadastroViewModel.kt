package com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ActCadastroViewModel @Inject constructor() : ViewModel() {
    private val _tituloCabecario = MutableStateFlow("Dados Pessoais")
    val tituloCabecario: StateFlow<String> = _tituloCabecario

    private val _proximaTela = MutableStateFlow("DadosPessoais")
    val proximaTela: StateFlow<String> = _proximaTela

    fun atualizarTituloCabecario(novoTitulo: String) {
        _tituloCabecario.value = novoTitulo
    }

    fun navegaProximaTela(novaTela: String) {
        _proximaTela.value = novaTela
    }

    fun resetaTela() {
        _proximaTela.value = ""

    }
}