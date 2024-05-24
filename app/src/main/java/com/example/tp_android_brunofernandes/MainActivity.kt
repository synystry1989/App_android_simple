package com.example.tp_android_brunofernandes


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tp_android_brunofernandes.databinding.ActivityMainBinding
import com.example.tp_android_brunofernandes.databinding.ActivityPagInicialBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.buttonSignin.setOnClickListener {
            //Users admitidos
            val usernameA1: String = "bruno"
            val passwordA1: String = "123"
            val usernameA2: String = "admin"
            val passwordA2: String = "password123"
            val usernameA3: String = "it"
            val passwordA3: String = "pastelNata"

            //leitura dados introduzidos
            var username: String = binding.editNome.text.toString()
            var password: String = binding.editPassword.text.toString()


            //verificacoes
            if (usernameA1 == username && passwordA1 == password || usernameA2 == username && passwordA2 == password || usernameA3 == username && passwordA3 == password) {
                val i: Intent = Intent(this, ActivityPagInicialBinding ::class.java)
                i.putExtra("user", username)
                startActivity(i)
            } else {
                Toast.makeText(
                    applicationContext,
                    "Dados inválidos",
                    Toast.LENGTH_SHORT
                ).show()
            }

            //apagar campos apos login
            binding.editNome.text.clear()
            binding.editPassword.text.clear()
        }
    }
}