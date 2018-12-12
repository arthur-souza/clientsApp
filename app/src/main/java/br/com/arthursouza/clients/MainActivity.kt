package br.com.arthursouza.clients

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Adicionar um evento no botão de cadastrar para abrir a tela de cadastro */
        val btnRegister : Button = this.findViewById(R.id.btn_register)
        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity ::class.java)
            startActivity(intent)
        }

        /* Adicionar um evento no botão de cadastrar para abrir a tela de clientes */
        val btnClients : Button = this.findViewById(R.id.btn_clients)
        btnClients.setOnClickListener {
            val itent = Intent(this, ClientsActivity ::class.java)
            startActivity(itent)
        }
    }
}
