package com.example.appfrella.Presenter.View.Atividades

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.appfrella.Presenter.ViewModel.Factory.ActDadosPessoaisFactory
import com.example.appfrella.Presenter.ViewModel.Factory.ActDadosPessoaisViewModel
import com.example.appfrella.R
import com.example.appfrella.Utis.extensoes.MascarasEdit.Companion.mascaraCpf
import com.example.appfrella.Utis.extensoes.MascarasEdit.Companion.mascaraData
import com.example.appfrella.Utis.extensoes.MascarasEdit.Companion.mascaraTelefone
import com.example.appfrella.Utis.extensoes.ValidarCampos.Companion.validaCPF
import com.example.appfrella.Utis.extensoes.ValidarCampos.Companion.validaCampoComum
import com.example.appfrella.Utis.extensoes.ValidarCampos.Companion.validaEmail
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
        binding.inputCpf.mascaraCpf()
        binding.inputTelefone.mascaraTelefone()

        val factory = ActDadosPessoaisFactory()
        val viewModel = ViewModelProvider(this, factory).get(ActDadosPessoaisViewModel::class.java)
        viewModel.checkPolitica.observe(this) { check ->
            if (check){
                binding.checkboxPolitica.setBackgroundResource(R.drawable.bordas_check_2_blue)
                binding.imgCheck.visibility = View.VISIBLE
            }else{
                binding.checkboxPolitica.setBackgroundResource(R.drawable.bordas_gray_50_radius_2)
                binding.imgCheck.visibility = View.GONE

            }
        }

        binding.checkboxPolitica.setOnClickListener {
            val check = if(viewModel.checkPolitica.value == true) false else true
            viewModel.setCheckPolitica(check)
        }

        binding.inputCpf.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val cpf = p0.toString().length
                if(cpf == 14){
                    binding.inputCpf.validaCPF()
                }else{
                    binding.inputCpf.error = null
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        binding.inputEmail.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.inputEmail.validaEmail()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        binding.inputConfirmaEmail.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.inputConfirmaEmail.validaEmail()
                if(binding.inputConfirmaEmail.text.toString() != binding.inputEmail.text.toString()){
                    binding.inputConfirmaEmail.error = "E-mail não confere"
                }else{
                    binding.inputConfirmaEmail.error = null
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        binding.setaVoltar.setOnClickListener {
            finish()
        }
        binding.inputNome.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.inputNome.validaCampoComum(p0.toString().isEmpty())
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}