package com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appfrella.projeto.Modulos.Cadastro.CadastroRepository
import com.example.appfrella.projeto.Modulos.Cadastro.CadastroServices
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel.ScrenDadosEnderecoViewModel

class ScrrenDadosEnderecoPessoalFactory  (val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScrenDadosEnderecoViewModel::class.java)) {
            val cadastroRepository = CadastroRepository(context )
            val cadastroServices = CadastroServices(cadastroRepository)
            return ScrenDadosEnderecoViewModel(cadastroServices) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}