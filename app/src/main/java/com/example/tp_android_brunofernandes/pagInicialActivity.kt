package com.example.tp_android_brunofernandes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tp_android_brunofernandes.databinding.ActivityPagInicialBinding

class pagInicialActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityPagInicialBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent
//receber o valor da variavel da actividade anterior
        val username = i.extras?.getString("user")
        if(username!= null) {
            binding.textBemVindo.text = "Bem-vindo ${username}"
        }else{
            binding.textBemVindo.text = "Escolha entre as opcoes:"
        }

        binding.buttonRegistar.setOnClickListener{
            startActivity(Intent(this, regProdutoActivity::class.java))
        }
        binding.buttonLogout.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}