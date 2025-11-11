package br.com.bes.gerenciadorUsuario.repositoy

import br.com.bes.gerenciadorUsuario.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {

}