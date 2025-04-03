package com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel

import androidx.lifecycle.ViewModel
import com.example.appfrella.projeto.Modulos.Cadastro.CadastroServices
import com.example.appfrella.projeto.Modulos.Cadastro.Model.BancoResponseItem
import com.example.appfrella.projeto.Utils.RespostaPadraoAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ScrenDadosBancariosViewModel @Inject constructor (
    val cadastroServices: CadastroServices
) :ViewModel() {
    private val _bancoSelecionado = MutableStateFlow("Banco")
    val bancoSelecionado: StateFlow<String> = _bancoSelecionado

    private val _mostraModalBanco = MutableStateFlow(false)
    val mostraBanco: StateFlow<Boolean> = _mostraModalBanco

    private val _mensagemErro = MutableStateFlow("")
    val mensagemErro: StateFlow<String> = _mensagemErro

    private val _mostraModalErro = MutableStateFlow(false)
    val mostraModalErro: StateFlow<Boolean> = _mostraModalErro

    private val _litaBanco = MutableStateFlow(arrayListOf<BancoResponseItem>())
    val listaBanco: StateFlow<ArrayList<BancoResponseItem>> = _litaBanco

    private val _mostraProgress = MutableStateFlow(false)
    val mostraProgress: StateFlow<Boolean> = _mostraProgress


    fun mostraModalErro( mensagenm: String, mostraModal: Boolean = true) {
        _mostraModalErro.value = mostraModal
        _mensagemErro.value = mensagenm
    }

    fun mostraModalBanco(mostraModal: Boolean = true) {
        _mostraModalBanco.value = mostraModal
    }



    fun setBancoSelecionado(banco: String) {
        _bancoSelecionado.value = banco
    }

    fun buscarBanco(){
        MainScope().launch {
            _mostraProgress.value = true
            CoroutineScope(Dispatchers.IO).launch {
                val result = cadastroServices.buscaBancoServices()
                MainScope().launch {
                    _mostraProgress.value = false
                    if(result is String  ){
                        mostraModalErro(result)
                    }else{
                        _litaBanco.value = result as ArrayList<BancoResponseItem>
                    }
                }

            }
        }
    }
}