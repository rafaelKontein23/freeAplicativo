package com.example.appfrella.projeto.Modulos.Cadastro.Model

data class CidadeResponse(
    val list: List<CidadeResponseItem>

)


data class CidadeResponseItem(
    val id:Long,
    val nome:String
)