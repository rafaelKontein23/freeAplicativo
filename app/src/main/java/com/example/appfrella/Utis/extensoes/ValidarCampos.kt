package com.example.appfrella.Utis.extensoes

import android.widget.EditText
import com.example.appfrella.Utis.ValidarTexto.ValidaCPF

class ValidarCampos {

    companion object {
        fun EditText.validaCPF(){
            if (ValidaCPF.isValidCPF(this.text.toString())){
                this.error = null
            }else{
                this.error = "CPF inválido"
            }
        }
        fun EditText.validaEmail(){
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(this.text.toString()).matches()){
                this.error = null
            }else{
                this.error = "E-mail inválido"
            }
        }
        fun EditText.validaCampoComum(erro:Boolean){
            if (erro){
                this.error = "Campo obrigatório"
            }else{
                this.error = null
            }
        }
    }
}