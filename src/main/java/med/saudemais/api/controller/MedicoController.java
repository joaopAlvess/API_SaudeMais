package med.saudemais.api.controller;

import jakarta.validation.Valid;
import med.saudemais.api.medico.DadosCadastroMedico;
import med.saudemais.api.medico.Medico;
import med.saudemais.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired          // Com esse atributo o próprio Spring Boot irá instanciar e passar esse atributo.
    private MedicoRepository repository;            // Aqui estou pegando para utilizar a interface do MedicoRepository para que ele persista e fique no Banco de Dados

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
}
