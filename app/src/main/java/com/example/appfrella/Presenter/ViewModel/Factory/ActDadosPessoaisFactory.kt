package com.example.appfrella.Presenter.ViewModel.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ActDadosPessoaisFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActDadosPessoaisViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ActDadosPessoaisViewModel() as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}