package com.example.appfrella.Presenter.View.Atividades

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.appfrella.Presenter.ViewModel.Factory.ActDadosPessoaisFactory
import com.example.appfrella.Presenter.ViewModel.Factory.ActDadosPessoaisViewModel
import com.example.appfrella.R
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
        val listener = MaskedTextChangedListener(
            primaryFormat = "[00]{/}[00]{/}[0000]", // Máscara para DD/MM/YYYY
            field = this.binding.inputDataNascimento,
            listener = null // Listener opcional
        )

        val factory = ActDadosPessoaisFactory()
        val viewModel = ViewModelProvider(this, factory).get(ActDadosPessoaisViewModel::class.java)
        viewModel.checkPolitica.observe(this) { check ->
            if (check){
                // fazer o estilo aqui ....
            }else{
            }
        }

        binding.checkboxPolitica.setOnClickListener {
            val check = if(viewModel.checkPolitica.value == true) false else true
            viewModel.setCheckPolitica(check)
        }
        // Adiciona o listener ao EditText
        binding.inputDataNascimento.addTextChangedListener(listener)

        // Configura o listener de foco
        binding.inputDataNascimento.onFocusChangeListener = listener


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}