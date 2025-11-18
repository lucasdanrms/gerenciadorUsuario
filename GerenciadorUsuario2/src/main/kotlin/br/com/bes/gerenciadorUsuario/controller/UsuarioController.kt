package br.com.bes.gerenciadorUsuario.controller
// as importações necessaria serao criadas automaticamente enquanto voce esta escrevendo o codigo
import br.com.bes.gerenciadorUsuario.model.Usuario
import br.com.bes.gerenciadorUsuario.repositoy.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
        return "redirect:/home"
}
    // função que vai abrir a página home
    @GetMapping("/home")
    fun abrirHome(model: Model): String {
        // buscar todos os usuarios do banco de dados
        val usuarios = repositorio.findAll()

        // Colocar a lista de usuarios no model
        // model envia a lista de usuarios para o HTML
        model.addAttribute("usuarios", usuarios)
        return "home"
    }

    //função que vai excluir o usuario
    //recebe o id do usuario na rota /excluir
    @GetMapping("/excluir/{id}")
    fun excluirUsuario(@PathVariable("id") id: Long): String {
        //excluir usuario
        repositorio.deleteById(id)
        return "redirect:/home"
    }

    // função que vai abrir o formulario de edição
    // com os dados do usuario
    // recebe o id do usuario na rota /formulario/edicao
    @GetMapping("/formulario/edicao/{id}")
    fun abrirFormularioEdicao(@PathVariable("id")id: Long, model: Model): String{
        // busca o usuario no bd
        // se não encontrar retorna nulo - orElse(null)
        val usuario = repositorio.findById(id).orElse(null)

        // passa os dados para o html - model
        model.addAttribute("usuarioEdit", usuario)
        return "formulario-edicao"
    }

    @PostMapping("/editar/{id}")
    fun editarUsuario(usuario: Usuario, @PathVariable("id") id: Long): String {

        // Inclui no objeto usuario o id recebido
        usuario.id = id

        // atualiza os dados no bd
        // save() tem dupla função:
        // quando o usuario não tem o id - salva
        // quando o usuario tem um id que já existe no bd - atualiza
        repositorio.save(usuario)

        // após editar ir para /home
        // carregar a listar todos os registros

        return "redirect:/home"
    }

}