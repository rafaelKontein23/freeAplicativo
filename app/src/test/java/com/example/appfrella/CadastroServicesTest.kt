package com.example.appfrella

import android.content.Context
import com.example.appfrella.projeto.Modulos.Cadastro.CadastroRepository
import com.example.appfrella.projeto.Modulos.Cadastro.CadastroServices
import com.example.appfrella.projeto.Modulos.Cadastro.Model.BancoResponseItem
import com.example.appfrella.projeto.Modulos.Cadastro.SincronoCadastro
import com.example.appfrella.projeto.Utils.RespostaPadraoAPI
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import okhttp3.ResponseBody
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.*
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.Call
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class CadastroServicesTest {

    private val cadastroRepository = mock(CadastroRepository::class.java)
    private val cadastroServices = CadastroServices(cadastroRepository)

    @Test
    fun `deve retornar lista de bancos quando valido for true`() {
        // Simula a resposta esperada
        val bancosMock = listOf(
            BancoResponseItem( 12, "Banco A", "123456789", ""),
            BancoResponseItem( 12, "Banco B", "123456789", ""),

        )
        val respostaMock = RespostaPadraoAPI(true, bancosMock, "")

        // Configura o mock
        whenever(cadastroRepository.buscaBancoRepository()).thenReturn(respostaMock)

        // Executa o método
        val resultado = cadastroServices.buscaBancoServices()

        // Valida o retorno
        assertEquals(bancosMock, resultado) // o primeiro paremtro é o esperado e o segundo é o resultado que vem da função
    }

    @Test
    fun `deve retornar uma string de erro quando valido for false` (){
        val respostaMock = RespostaPadraoAPI(false, null, "Algo deu errado")
        whenever(cadastroRepository.buscaBancoRepository()).thenReturn(respostaMock)
        val resultado = cadastroServices.buscaBancoServices()
        assertTrue( resultado is String)
    }


    @Test
    fun `deve retornar uma resposta null`() {
        whenever(cadastroRepository.buscaBancoRepository()).thenReturn(null)
        val resultado = cadastroServices.buscaBancoServices()
        assertEquals(null, resultado)
    }
}