package com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel

import androidx.lifecycle.ViewModel
import com.example.appfrella.projeto.Modulos.Cadastro.CadastroServices
import com.example.appfrella.projeto.Modulos.Cadastro.Model.CepResponse
import com.example.appfrella.projeto.Modulos.Cadastro.Model.CidadeResponse
import com.example.appfrella.projeto.Modulos.Cadastro.Model.CidadeResponseItem
import com.example.appfrella.projeto.Utils.AlimentaListas
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ScrenDadosEnderecoViewModel @Inject constructor(
    private val cadastroServices: CadastroServices
) : ViewModel() {

    private val _listaUF = MutableStateFlow(arrayListOf<String>())
    val listaUF: StateFlow<List<String>> = _listaUF

    private val _erro = MutableStateFlow(String())
    val erro : MutableStateFlow<String> = _erro

    private val _mostraModalErro = MutableStateFlow(false)
    val mostraModalErro: StateFlow<Boolean> = _mostraModalErro

    private val _ufSelecionado = MutableStateFlow("Estado")
    val ufSelecionado: StateFlow<String> = _ufSelecionado


    private val _listaCidades = MutableStateFlow(arrayListOf<CidadeResponseItem>())
    val listaCidades: StateFlow<ArrayList<CidadeResponseItem>> = _listaCidades




    private val _cep = MutableStateFlow(CepResponse())
    val cep: StateFlow<CepResponse> = _cep

    private val mostrarProgress = MutableStateFlow(false)
    val mostraProgress: StateFlow<Boolean> = mostrarProgress

    private val _cidadeSelecionada = MutableStateFlow("Cidade")
    val cidadeSelecionada: StateFlow<String> = _cidadeSelecionada

    fun mostraModalErro( mensagenm: String) {
        _mostraModalErro.value = true
        _erro.value = mensagenm
    }


    fun fecharModalErro() {
        _mostraModalErro.value = false
    }
    fun atualizarListaUF() {
        val povoaUF = AlimentaListas()
        _listaUF.value = povoaUF.alimentaListaUF()
    }

    fun buscarDadosCEP(cep: String) {
        CoroutineScope(Dispatchers.Main).launch {
            mostrarProgress.value = true
            CoroutineScope(Dispatchers.IO).launch {
                val resultado = cadastroServices.buscaCepServices(cep)
                withContext(Dispatchers.Main) {
                    mostrarProgress.value = false
                    if (resultado is String) {
                        _erro.value = resultado
                        _mostraModalErro.value = true
                    } else {
                        _cep.value = resultado as CepResponse
                    }
                }
            }
        }
    }


    fun buscaCidadesUF(uf: String) {
        CoroutineScope(Dispatchers.Main).launch {
            mostrarProgress.value = true
            CoroutineScope(Dispatchers.IO).launch {
                val resultado = cadastroServices.buscaCidadeServices(uf)
                withContext(Dispatchers.Main) {
                    mostrarProgress.value = false
                    if (resultado is String) {
                        _erro.value = resultado
                        _mostraModalErro.value = true
                    }else{
                        _listaCidades.value = resultado as ArrayList<CidadeResponseItem>
                    }
                }

            }
        }
    }

    fun  atualizarCidadeSelecionada(cidade: String){
        _cidadeSelecionada.value = cidade

    }

    fun atualizaMensagemErro(error: String){
        _erro.value = error
    }

    fun atualizarUfSelecionado(uf: String) {
        _ufSelecionado.value = uf
        val siglaUF = uf.substring(0, 2)
        buscaCidadesUF(siglaUF)
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