package com.example.appfrella.projeto.Modulos.Cadastro.Model

data class CepResponse (
     val cep:String,
     val logradouro:String,
     val complemento:String,
     val bairro:String,
     val uf:String,
     val estado:String,
     val regiao:String

){
    constructor() : this("", "", "", "", "", "", "")
}