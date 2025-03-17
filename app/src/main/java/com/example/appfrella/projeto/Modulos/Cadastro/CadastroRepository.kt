package com.example.appfrella.projeto.Modulos.Cadastro

import android.content.Context
import com.example.appfrella.projeto.Config.RetrofitConfig
import com.example.appfrella.projeto.Modulos.Cadastro.Model.CepResponse
import com.google.gson.Gson
import java.io.IOException
import kotlin.jvm.Throws

class CadastroRepository(context: Context) {
    val retrofit = RetrofitConfig().createService(SincronoCadastro::class.java)

    fun buscaCepRepository(cep:String): CepResponse? {
        try {
            val request = retrofit.buscaCep(cep).execute()
            if(request.isSuccessful){
                val response = request.body() as CepResponse
                return response

            }else{
                return null

            }
        }catch (e:Exception){
            e.printStackTrace()
            return null
        }catch (io: IOException){
            io.printStackTrace()
            return null
        }
    }
}