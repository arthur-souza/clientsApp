package br.com.arthursouza.clients

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val txtName : EditText =  this.findViewById(R.id.txt_name) // Seleciona o input de nome
        val txtCpf : EditText = this.findViewById(R.id.txt_cpf) // Seleciona o input de cpf
        val txtBirth : EditText = this.findViewById(R.id.txt_birth) // Seleciona o input de data de nascimento
        val btnCancel : Button = this.findViewById(R.id.btn_cancel) // Seleciona o botão de cancelar
        val btnSave : Button = this.findViewById(R.id.btn_save) // Seleciona o botão de salvar

        // Adiciona um evento no botão de cancelar para voltar par tela inicial
        btnCancel.setOnClickListener {
//            val db = DataBaseHandler(this);
//            val data = db.getData()
//
//            for (index in data) {
//                println("name: ${index.name}")
//            }

            super.onBackPressed()
        }

        // Adicona evento no botão de salvar
        btnSave.setOnClickListener {
            var name = txtName.text.toString()
            var cpf = txtCpf.text.toString()
            var dateBirth = txtBirth.text.toString()

            // Verifica de todos os campos foram preenchidos
            if (name.length > 0 && cpf.length > 0 && dateBirth.length > 0) {
                val client = Client(name, cpf, dateBirth) // Criando objeto cliente
                val db = DataBaseHandler(this) // Criando conexão com banco de dados
                db.insertData(client) // Inserindo dados no banco

                super.onBackPressed() // Voltando para tela inicial
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
