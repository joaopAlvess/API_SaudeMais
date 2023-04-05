package med.saudemais.api.controller;

import jakarta.validation.Valid;
import med.saudemais.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired          // Com esse atributo o próprio Spring Boot irá instanciar e passar esse atributo.
    private MedicoRepository repository;            // Aqui estou pegando para utilizar a interface do MedicoRepository para que ele persista e fique no Banco de Dados

    //----------------------------------------------------------------------------------------

    //MÉTODO POST

    //OBS: Se atentar a métodos e parâmetros.
    // Aqui como estou fazendo um Post para a a web, deve utilizar o @PostMapping, depois dentro do método devo passar um parametro de @Request body, para que o Json seja carregado no terminal, traduzindo ele saiba de onde pegar o Json.
    @PostMapping
    @Transactional
         // Vai fazer um transação ativa com o BD //Se atentar e colocar o método do Spring (org.spring)
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico data) {
        repository.save(new Medico(data));
    }

    // Utilizando o contrutor dessa maneira fazendo referencia direta com (data) DadosCadastroMédico, ele irá reclamar pois preciso
    //criar uma class dentro de DadosCadastroMedico e definir todos os atributos.

    // ---------------------------------------------------------------------------------------------

    //MÉTODO GET

    // Nesse caso estou criando uma nova classe e estou colocando Lista para armazenar as informações devolvidas, o Generics está Instanciando da Classe Medico
    // Estou passando como parametro Pageable para definir a quantidade de registro que quero lançar por vez a cada página, pense como um livro, se quero lançar somente 10 registros por página irei definir aqui
    @GetMapping
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginator) {
        return repository.findAll(paginator).map(DadosListagemMedicos::new);
    }

    // -------------------------------------------------------------------------------------------------

    //MÉTODO PUT

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaMedico data) {
        var medico = repository.getReferenceById(data.id());
        medico.atualizarInformacoes(data);
    }
}

