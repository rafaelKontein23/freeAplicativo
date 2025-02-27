package com.example.appfrella.Presenter.ViewModel.Factory

import androidx.lifecycle.ViewModel
import com.example.appfrella.Utis.povoar.PovoaUF
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ScrenDadosEnderecoViewModel : ViewModel()  {

    private val _listaUF = MutableStateFlow(arrayListOf<String>())
    val listaUF: StateFlow<List<String>> = _listaUF

    fun atualizarListaUF() {
        val povoaUF = PovoaUF()
        _listaUF.value = povoaUF.alimentaListaUF()
    }

}