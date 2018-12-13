package br.com.arthursouza.clients

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DB_NAME =  "clients.db"
val DB_VERSION = 1
val TABLE_NAME = "clients"
val COL_ID = "id"
val COL_NAME = "name"
val COL_CPF = "cpf"
val COL_DATEBIRTH = "dataBirth"

class DataBaseHandler(var context : Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db : SQLiteDatabase?) {
        /* Query para criar a tabela no banco de dados */
        val createTable = "CREATE TABLE " + TABLE_NAME +" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME +" VARCHAR(100)," +
                COL_CPF +" VARCHAR(15)," +
                COL_DATEBIRTH +" VARCHAR(10))"

        /* Executando a query para criar a tabela */
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db : SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        /* Apagando o banco de dados quando a estrutura do banco for alterada */
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        this.onCreate(db) // Criando o banco de dados novamente;
    }

    /* Função responsável por inserir novos dados no banco */
    fun insertData(client : Client) {
        val db = this.writableDatabase
        var cv = ContentValues()

        /* Inserindo dados do cliente */
        cv.put(COL_NAME, client.name)
        cv.put(COL_CPF, client.cpf)
        cv.put(COL_DATEBIRTH, client.dateBirth)

        /* Persistindo dados */
        var result = db.insert(TABLE_NAME, null, cv)

        if (result == -1.toLong())
            // Exibindo mensagem de erro
            Toast.makeText(context, "Falhou", Toast.LENGTH_SHORT).show()
        else
            // Exibindo mensagem de sucesso
            Toast.makeText(context, "Sucesso", Toast.LENGTH_SHORT).show()
    }

    /* Função responsável por recuperar os dados no banco */
    fun getData(): ArrayList<Client> {
        val clientList = ArrayList<Client>() // Criando lista de clientes
        val db = this.writableDatabase // conectando com banco de dados;
        val query = "SELECT * FROM " + TABLE_NAME // Criando a query de consulta
        val clients = db.rawQuery(query, null) // rodando a query no banco de dados

        /* Verificando se existe dados */
        if (clients != null) {
            clients.moveToFirst()

            /* Percorrendo os dados do banco para inserir na lista de clientes */
            while (clients.moveToNext()) {
                val client = Client() // Criando o objeto cliente

                /* Popula o objeto cliente com os dados do banco de dados */
                client.id = clients.getString(clients.getColumnIndex(COL_ID)).toInt()
                client.name = clients.getString(clients.getColumnIndex(COL_NAME))
                client.cpf = clients.getString(clients.getColumnIndex(COL_CPF))
                client.dateBirth = clients.getString(clients.getColumnIndex(COL_DATEBIRTH))

                /* Inserindo o objero cliente no array de clientes */
                clientList.add(client)
            }
        }

        clients.close()
        return clientList
    }

}