package com.example.appfrella.projeto.Modulos.Cadastro

import com.example.appfrella.projeto.Utils.Constantes
import com.example.appfrella.projeto.Utils.RespostaPadraoAPI
import com.google.gson.Gson
import java.io.IOException
import javax.inject.Inject

open class CadastroRepository @Inject constructor(
    private val retrofit: SincronoCadastro
) {

    fun buscaCepRepository(cep: String): RespostaPadraoAPI? {
        try {
            val request = retrofit.buscaCep(cep).execute()
            if (request.isSuccessful) {
                val response = request.body()?.string()
                val gson = Gson()
                val cepResponse = gson.fromJson(response, RespostaPadraoAPI::class.java)
                return cepResponse
            } else {
                return RespostaPadraoAPI(false, null, "Algo deu ao buscar Dados Do Cep")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return RespostaPadraoAPI(false, null, "Algo deu ao buscar Dados Do Cep")

        } catch (io: IOException) {
            io.printStackTrace()
            return RespostaPadraoAPI(false, null, Constantes.erroInternet)
        }
    }

    fun buscaCidadeRepository(uf: String): RespostaPadraoAPI? {
        try {
            val request = retrofit.buscaCidade(uf).execute()
            if (request.isSuccessful) {
                val response = request.body()?.string()
                val gson = Gson()
                val cidadeResponse = gson.fromJson(response, RespostaPadraoAPI::class.java)
                return cidadeResponse
            } else {
                return RespostaPadraoAPI(false, null, "Algo deu ao buscar cidades ")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            return RespostaPadraoAPI(false, null, "Algo deu ao buscar cidades ")
        } catch (i: IOException) {
            i.printStackTrace()
            return RespostaPadraoAPI(false, null, Constantes.erroInternet)
        }
    }

    fun buscaBancoRepository(): RespostaPadraoAPI? {
        try {
            val request = retrofit.buscaBanco().execute()
            if (request.isSuccessful) {
                val response = request.body()?.string()
                val gson = Gson()
                val bancoResponse = gson.fromJson(response, RespostaPadraoAPI::class.java)
                return bancoResponse
            } else {
                return RespostaPadraoAPI(false, null, "Algo deu ao buscar bancos ")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            return RespostaPadraoAPI(false, null, "Algo deu ao buscar bancos ")
        } catch (i: IOException) {
            i.printStackTrace()
            return RespostaPadraoAPI(false, null, Constantes.erroInternet)
        }
    }
}