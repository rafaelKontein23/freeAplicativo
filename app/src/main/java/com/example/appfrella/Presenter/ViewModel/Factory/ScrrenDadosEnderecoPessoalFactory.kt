package com.example.appfrella.Presenter.ViewModel.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScrrenDadosEnderecoPessoalFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScrenDadosEnderecoViewModel::class.java)) {
            return ScrenDadosEnderecoViewModel() as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}