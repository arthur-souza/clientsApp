package br.com.arthursouza.clients

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

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
            super.onBackPressed()
        }
    }
}
