package br.com.bes.gerenciadorUsuario.controller
// as importações necessaria serao criadas automaticamente enquanto voce esta escrevendo o codigo
import br.com.bes.gerenciadorUsuario.model.Usuario
import br.com.bes.gerenciadorUsuario.repositoy.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller // Indica quw a classe vai ser um controller
class UsuarioController {
    // Inicializando o repositório de dados
    @Autowired
    lateinit var repositorio: UsuarioRepository



    // função que vai abrit o formulário
    @GetMapping("/formulario/cadastro") //recebe as requisições
    fun abrirFormularioCadastro(model: Model): String{

        //cria objeto da classe usuario vazio
        val usuario = Usuario()
        // faz o envio objeto da classe de dados para html
        model.addAttribute("usuarioNovo",usuario)

        return "formulario-cadastro"

    }
    // funçao que vai receber o objeto de dados do html
    @PostMapping("/cadastrar")
    fun cadastrarUsuario( usuario: Usuario): String {

        println(usuario)
        repositorio.save(usuario)
        return "home"
}
    // função que vai abrir a página home
    @GetMapping("/home")
    fun abrirHome(): String {
        // buscar todos os usuarios do banco de dados
        val usuarios = repositorio.findAll()
        return "home"
    }


}