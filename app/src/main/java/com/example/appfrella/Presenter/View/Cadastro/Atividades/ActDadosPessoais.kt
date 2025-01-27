package com.example.appfrella.Presenter.View.Cadastro.Atividades

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appfrella.R
import com.example.appfrella.Utis.extensoes.MascarasEdit.Companion.mascaraCPF
import com.example.appfrella.Utis.extensoes.MascarasEdit.Companion.mascaraData
import com.example.appfrella.Utis.extensoes.MascarasEdit.Companion.mascaraTelefone
import com.example.appfrella.Utis.extensoes.MascarasEdit.Companion.validaErro
import com.example.appfrella.Utis.validaTexto.ValidarTextos.Companion.isCPF
import com.example.appfrella.databinding.ActivityActDadosPessoaisBinding
import com.redmadrobot.inputmask.MaskedTextChangedListener

class ActDadosPessoais : AppCompatActivity() {
    private val binding by lazy {
        ActivityActDadosPessoaisBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.inputDataNascimento.mascaraData()
        binding.inputCpf.mascaraCPF()
        binding.inputTelefone.mascaraTelefone()
        binding.inputCpf.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               val validaCPF = binding.inputCpf.text.toString()
                if (validaCPF.length == 14){
                    val valida = isCPF(validaCPF)
                    if (valida){
                        binding.inputCpf.validaErro(false, "")
                    }else{
                        binding.inputCpf.validaErro(true, getString(R.string.erroCpf))

                    }
                }else{
                    binding.inputCpf.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}