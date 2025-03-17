package com.example.appfrella.projeto.Modulos.Cadastro

import android.content.Context
import com.example.appfrella.projeto.Config.RetrofitConfig
import com.example.appfrella.projeto.Utils.Constantes
import com.example.appfrella.projeto.Utils.RespostaPadraoAPI
import com.google.gson.Gson
import java.io.IOException

class CadastroRepository(context: Context) {
    val retrofit = RetrofitConfig().createService(SincronoCadastro::class.java)

    fun buscaCepRepository(cep:String): RespostaPadraoAPI? {
        try {
            val request = retrofit.buscaCep(cep).execute()
            if(request.isSuccessful){
                val response = request.body()?.string()
                val gson = Gson()
                val cepResponse = gson.fromJson(response, RespostaPadraoAPI::class.java)
                return cepResponse
            }else{
                return RespostaPadraoAPI(false, null, "Algo deu ao buscar Dados Do Cep")
            }
        }catch (e:Exception){
            e.printStackTrace()
            return RespostaPadraoAPI(false, null, "Algo deu ao buscar Dados Do Cep")

        }catch (io: IOException){
            io.printStackTrace()
            return RespostaPadraoAPI(false, null, Constantes.erroInternet)
        }
    }
}