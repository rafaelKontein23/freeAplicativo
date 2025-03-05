package com.example.appfrella.Presenter.ViewModel.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ActCadastroViewModelFactory :  ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActCadastroViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ActCadastroViewModel() as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}