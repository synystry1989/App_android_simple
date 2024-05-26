package com.example.tp_android_brunofernandes


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tp_android_brunofernandes.databinding.ActivityPrdutosBinding



class prdutosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrdutosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =  ActivityPrdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
//preencher os text com os valores vindos da atividade anterior
        binding.textNomePrdt.setText(i.getStringExtra("produto",))
        binding.textPreco.setText(i.getStringExtra("preco"))
        binding.textQtd.setText(i.getStringExtra("qtd"))


        binding.buttonGravar.setOnClickListener {

            Toast.makeText(applicationContext, "Operação concluida com sucesso", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, pagInicialActivity::class.java))

        }
//levar valores para a atividade anterior
        binding.buttonRetroceder.setOnClickListener{

            i.putExtra("produto",binding.textNomePrdt.text.toString())
            i.putExtra("preco",binding.textPreco.text.toString())
            i.putExtra("qtd",binding.textQtd.text.toString())


            setResult(1,i)
            finish()




        }

    }

}