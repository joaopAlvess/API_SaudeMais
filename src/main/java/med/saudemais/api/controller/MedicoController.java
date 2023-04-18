package med.saudemais.api.controller;

import jakarta.validation.Valid;
import med.saudemais.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


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
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico data, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(data);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new RecordDadoDetalhamentoMedico(medico));
    }

    // Utilizando o contrutor dessa maneira fazendo referencia direta com (data) DadosCadastroMédico, ele irá reclamar pois preciso
    //criar uma class dentro de DadosCadastroMedico e definir todos os atributos.

    // ---------------------------------------------------------------------------------------------

    //MÉTODO GET

    // Nesse caso estou criando uma nova classe e estou colocando Lista para armazenar as informações devolvidas, o Generics está Instanciando da Classe Medico
    // Estou passando como parametro Pageable para definir a quantidade de registro que quero lançar por vez a cada página, pense como um livro, se quero lançar somente 10 registros por página irei definir aqui
    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicos>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginator) {
        var page = repository.findAllByAtivoTrue(paginator).map(DadosListagemMedicos::new);
       return ResponseEntity.ok(page);

    //Após istanciar o tipo ResponseEntity devo fazer uma mudança, armazenar o repository dentro de uma variavel e depois depois devo retornar um método do ResponseEntity o .ok passando como parametro a variável armazenada.
    }

    @GetMapping("/{id}")
    public ResponseEntity listarUnico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new RecordDadoDetalhamentoMedico(medico));
    }


    // -------------------------------------------------------------------------------------------------

    //MÉTODO PUT

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaMedico data) {
        var medico = repository.getReferenceById(data.id());
        medico.atualizarInformacoes(data);

        return ResponseEntity.ok(new RecordDadoDetalhamentoMedico(medico));
    }

    //Nessa linha do var medico, estou recuperando um medico pelo id dele.
    // Nessa outra linha estou criando um método para atualizar porém estou definindo e parametrizando esse método em outra Class, que se encontra na Class de Medico.

    // -----------------------------------------------------------------------------------------------------------------------------

    //MÉTODO DELETE

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();

        // Nesse caso estou padronizando a requisição do tipo delete, adicionando um Status 204 que siginifica Ok, porém o corpo não tem conteúdo, para isso estou utilizando o Response Entity e logo após utilizo o método .noContent e depois passo o .build para cria-lo
        return  ResponseEntity.noContent().build();
    }
    //Aqui estou passando um paramêtro dinâmico na url, com esse {id} significa que quando a requisição chegar no http://localhost:8080/medicos/ o número passado depois dessa ultima barra será o id do médico retornado.
}
