package com.example.appfrella.Presenter.ViewModel.Factory

import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import com.example.appfrella.Utis.povoar.PovoaUF
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Locale

class ScrenDadosEnderecoViewModel : ViewModel()  {

    private val _listaUF = MutableStateFlow(arrayListOf<String>())
    val listaUF: StateFlow<List<String>> = _listaUF
    private val _ufSelecionado = MutableStateFlow("")
    val ufSelecionado: StateFlow<String> = _ufSelecionado

    fun atualizarListaUF() {
        val povoaUF = PovoaUF()
        _listaUF.value = povoaUF.alimentaListaUF()
    }

    fun atualizarUfSelecionado(uf: String) {
        _ufSelecionado.value = uf
    }

    fun filtraListaUF(texto:String){
        if(texto.isEmpty()){
            atualizarListaUF()
        }else{
            val povoaUF = PovoaUF()
            val lista  = povoaUF.alimentaListaUF()
            val listaFiltrada = lista.filter { it.lowercase(Locale.getDefault()).contains(texto) }
            _listaUF.value = listaFiltrada as ArrayList<String>
        }
    }

}