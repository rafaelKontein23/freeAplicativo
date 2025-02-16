package com.example.appfrella.Utis.ValidarTexto

class ValidaCPF {

    companion object{
        fun isValidCPF(cpf: String): Boolean {
            val cleanCpf = cpf.filter { it.isDigit() }

            if (cleanCpf.length != 11 || cleanCpf.all { it == cleanCpf[0] }) return false

            fun calculateDigit(cpf: String, weight: IntProgression): Int {
                val sum = weight.mapIndexed { index, i -> cpf[index].digitToInt() * i }.sum()
                val remainder = sum % 11
                return if (remainder < 2) 0 else 11 - remainder
            }

            val firstDigit = calculateDigit(cleanCpf, (10 downTo 2))
            val secondDigit = calculateDigit(cleanCpf, (11 downTo 2))

            return cleanCpf[9].digitToInt() == firstDigit && cleanCpf[10].digitToInt() == secondDigit
        }

        // Exemplos de uso:
        fun main() {
            println(isValidCPF("529.982.247-25")) // true (válido)
            println(isValidCPF("123.456.789-09")) // false (inválido)
            println(isValidCPF("111.111.111-11")) // false (sequência inválida)
        }

    }

}