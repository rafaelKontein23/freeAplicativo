package com.example.appfrella.projeto.Modulos.Cadastro.Presenter.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appfrella.projeto.Modulos.Cadastro.Presenter.viewModel.ActCadastroViewModel

class ActCadastroViewModelFactory :  ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActCadastroViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ActCadastroViewModel() as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}