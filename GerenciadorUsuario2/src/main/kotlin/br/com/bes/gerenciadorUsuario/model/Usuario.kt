package br.com.bes.gerenciadorUsuario.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

//INformar ao springboot que essa classe vai ser uma tabela no BD
@Entity
data class Usuario(
    //Definir um indentificador para a tabela
    //Chave primaria com Auto incremento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val nome: String = "",
    val email: String = "",
    val cpf: String = "",
    val senha: String = "",
    val funcao: String = "",

) {
}