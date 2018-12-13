package br.com.arthursouza.clients

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ClientInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_info)

        var name = this.findViewById<TextView>(R.id.txt_name)
        var cpf = this.findViewById<TextView>(R.id.txt_cpf)
        var dateBirth = this.findViewById<TextView>(R.id.txt_dateBirth)

        val client: Client = this.intent.extras.get("client") as Client

        name.text = client.name
        cpf.text = client.cpf
        dateBirth.text = client.dateBirth
    }
}
