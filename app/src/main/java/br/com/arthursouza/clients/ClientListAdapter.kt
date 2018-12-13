package br.com.arthursouza.clients

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ClientListAdapter(private var clients: ArrayList<Client>): RecyclerView.Adapter<ClientListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_item_client, parent, false))


    override fun getItemCount(): Int  = clients.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = holder.view.findViewById<TextView>(R.id.clientName)
        val cpf = holder.view.findViewById<TextView>(R.id.clientCpf)
        val btnShowClient = holder.view.findViewById<Button>(R.id.btn_clientShow)

        name.text = clients[position].name
        cpf.text = clients[position].cpf

        btnShowClient.setOnClickListener {
            println("Exibir Informação")
        }
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}