package com.example.appfrella.projeto.Modulos.Cadastro

import com.example.appfrella.projeto.Modulos.Cadastro.Model.CepResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SincronoCadastro {

    @GET("cidades/{cep}/json/")
    fun buscaCep(@Path("cep") cep:String):Call<ResponseBody>

}