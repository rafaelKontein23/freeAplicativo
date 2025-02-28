package com.example.appfrella.Utis.extensoes

import android.widget.EditText
import com.example.appfrella.Utis.ValidarTexto.ValidaCPF
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

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

        fun String.isIdadeValida(): Boolean {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

            val nascimento: Date
            try {
                nascimento = dateFormat.parse(this) ?: return false
            } catch (e: Exception) {
                return false
            }

            val hoje = Calendar.getInstance()

            val nascimentoCal = Calendar.getInstance().apply {
                time = nascimento
            }

            var idade = hoje.get(Calendar.YEAR) - nascimentoCal.get(Calendar.YEAR)

            if (hoje.get(Calendar.MONTH) < nascimentoCal.get(Calendar.MONTH) ||
                (hoje.get(Calendar.MONTH) == nascimentoCal.get(Calendar.MONTH) &&
                        hoje.get(Calendar.DAY_OF_MONTH) < nascimentoCal.get(Calendar.DAY_OF_MONTH))) {
                idade--
            }

            return idade in 16..79
        }

        fun String.removerNaoNumericos(): String {
            return this.filter { it.isDigit() }
        }
    }
}