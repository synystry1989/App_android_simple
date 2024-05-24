package com.example.tp_android_brunofernandes
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.tp_android_brunofernandes.databinding.ActivityRegProdutoBinding



class regProdutoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegProdutoBinding
    private  lateinit var result: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAvancar.setOnClickListener {
            var produto: String = binding.editNomeProduto.text.toString()
            var preco: String = binding.editPreco.text.toString()
            var quantidade: String = binding.editQuantidade.text.toString()

            if (produto.isEmpty() || preco.isEmpty() || quantidade.isEmpty()) {
                Toast.makeText(applicationContext, "preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else
            {
                val i: Intent=Intent(this, prdutosActivity::class.java)
                i.putExtra("produto", produto)
                i.putExtra("preco", preco)
                i.putExtra("qtd", quantidade)
                result.launch(i)

            }
            result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.data != null && it.resultCode==1){
                    produto = it.data?.getStringExtra("produto").toString()
                    binding.editNomeProduto.setText(produto)
                    preco = it.data?.getStringExtra("preco").toString()
                    binding.editPreco.setText(preco) //pega o valor do preco
                    quantidade = it.data?.getStringExtra("qtd").toString()
                    binding.editQuantidade.setText(quantidade)
                }
            }
        }
    }
}
