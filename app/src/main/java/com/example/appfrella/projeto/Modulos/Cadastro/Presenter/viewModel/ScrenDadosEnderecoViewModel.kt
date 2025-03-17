package com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel

import androidx.lifecycle.ViewModel
import com.example.appfrella.projeto.Modulos.Cadastro.CadastroServices
import com.example.appfrella.projeto.Modulos.Cadastro.Model.CepResponse
import com.example.appfrella.projeto.Utils.AlimentaListas
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Locale

class ScrenDadosEnderecoViewModel(
    private val cadastroServices: CadastroServices
) : ViewModel() {

    private val _listaUF = MutableStateFlow(arrayListOf<String>())
    val listaUF: StateFlow<List<String>> = _listaUF

    private val _erro = MutableStateFlow(String())
    val erro : MutableStateFlow<String> = _erro

    private val _ufSelecionado = MutableStateFlow("Estado")
    val ufSelecionado: StateFlow<String> = _ufSelecionado


    private val _cep = MutableStateFlow(CepResponse())
    val cep: StateFlow<CepResponse> = _cep


    fun atualizarListaUF() {
        val povoaUF = AlimentaListas()
        _listaUF.value = povoaUF.alimentaListaUF()
    }

    fun buscarDadosCEP(cep: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val resultado = cadastroServices.buscaCepServices(cep)
            if (resultado is String) {
                _erro.value = "Erro na requisição"
            } else {
                _cep.value = resultado as CepResponse
            }

        }
    }

    fun atualizaMensagemErro(error: String){
        _erro.value = error
    }

    fun atualizarUfSelecionado(uf: String) {
        _ufSelecionado.value = uf
    }

    fun filtraListaUF(texto: String) {
        if (texto.isEmpty()) {
            atualizarListaUF()
        } else {
            val povoaUF = AlimentaListas()
            val lista = povoaUF.alimentaListaUF()
            val listaFiltrada = lista.filter { it.lowercase(Locale.getDefault()).contains(texto) }
            _listaUF.value = listaFiltrada as ArrayList<String>
        }
    }
}