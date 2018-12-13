package br.com.arthursouza.clients

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_clients.*

class ClientsActivity : AppCompatActivity() {

    var adapter: ClientListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clients)
        adapter = ClientListAdapter(clients = DataBaseHandler(this).getData())
        recycleContent.layoutManager = LinearLayoutManager(this)
        recycleContent.adapter = adapter
    }
}
