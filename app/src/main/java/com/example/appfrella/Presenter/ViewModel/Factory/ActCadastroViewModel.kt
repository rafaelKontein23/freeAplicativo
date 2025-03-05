package com.example.appfrella.Presenter.ViewModel.Factory

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ActCadastroViewModel : ViewModel() {
    private val _tituloCabecario = MutableStateFlow(String())
    val tituloCabecario: StateFlow<String> = _tituloCabecario

    fun atualizarTituloCabecario(novoTitulo: String) {
        _tituloCabecario.value = novoTitulo
    }
}