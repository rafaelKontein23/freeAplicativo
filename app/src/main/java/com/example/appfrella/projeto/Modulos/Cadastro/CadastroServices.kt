package com.example.appfrella.projeto.Modulos.Cadastro

import com.example.appfrella.projeto.Modulos.Cadastro.Model.CepResponse
import com.example.appfrella.projeto.Modulos.Cadastro.Model.CidadeResponse
import com.example.appfrella.projeto.Modulos.Cadastro.Model.CidadeResponseItem
import com.google.gson.Gson


class CadastroServices ( val cadastroRepository: CadastroRepository)  {


    fun  buscaCepServices(cep:String) : Any? {
        val resultado = cadastroRepository.buscaCepRepository(cep)
        if (resultado?.valido == true) {
            val jsonDados = Gson().toJson(resultado.dados)
            return Gson().fromJson(jsonDados, CepResponse::class.java)
        }else{
            return resultado?.mensagem;
        }
    }


    fun buscaCidadeServices(uf:String) : Any? {
        val resultado = cadastroRepository.buscaCidadeRepository(uf)
        if (resultado?.valido == true) {
            val jsonDados = Gson().toJson(resultado.dados)
            val gson = Gson()
            val cidadesList: List<CidadeResponseItem> = gson.fromJson(jsonDados, Array<CidadeResponseItem>::class.java).toList()
            return cidadesList
        }else{
            return resultado?.mensagem;
        }
    }

}