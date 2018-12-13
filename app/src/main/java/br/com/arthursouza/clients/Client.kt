package br.com.arthursouza.clients

class Client {
    var id : Int = 0
    var name : String = ""
    var cpf : String = ""
    var dateBirth : String = ""

    constructor()

    constructor(name: String, cpf: String, dateBirth: String) {
        this.name = name
        this.cpf = cpf
        this.dateBirth = dateBirth
    }
}