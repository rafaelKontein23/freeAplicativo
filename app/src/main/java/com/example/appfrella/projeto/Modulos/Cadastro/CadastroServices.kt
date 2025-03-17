package com.example.appfrella.projeto.Modulos.Cadastro

import com.example.appfrella.projeto.Modulos.Cadastro.Model.CepResponse


class CadastroServices ( val cadastroRepository: CadastroRepository)  {


    fun  buscaCepServices(cep:String) : CepResponse? {
        val resultado = cadastroRepository.buscaCepRepository(cep)
        return resultado
    }

}