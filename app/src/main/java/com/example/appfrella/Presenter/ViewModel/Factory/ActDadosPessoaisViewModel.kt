package com.example.appfrella.Presenter.ViewModel.Factory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActDadosPessoaisViewModel :ViewModel(){
    var checkPolitica = MutableLiveData<Boolean>()
    private val _checkPolitica get() = checkPolitica
    fun setCheckPolitica(check: Boolean) {

        _checkPolitica.value = check
    }

}