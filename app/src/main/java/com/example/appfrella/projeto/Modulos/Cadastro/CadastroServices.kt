package com.example.appfrella.projeto.Modulos.Cadastro

import com.example.appfrella.projeto.Modulos.Cadastro.Model.CepResponse
import com.google.gson.Gson


class CadastroServices ( val cadastroRepository: CadastroRepository)  {


  suspend  fun  buscaCepServices(cep:String) : Any? {
        val resultado = cadastroRepository.buscaCepRepository(cep)
        if (resultado?.valido == true) {
            val jsonDados = Gson().toJson(resultado.dados)
            return Gson().fromJson(jsonDados, CepResponse::class.java)
        }else{
            return resultado?.mensagem;
        }
    }

}