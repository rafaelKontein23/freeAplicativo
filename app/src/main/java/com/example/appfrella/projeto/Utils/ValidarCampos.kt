package com.example.appfrella.projeto.Utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ValidarCampos {

    companion object {


        fun String.isIdadeValida(): Boolean {

            val dateFormat = SimpleDateFormat("ddMMyyyy", Locale.getDefault())

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