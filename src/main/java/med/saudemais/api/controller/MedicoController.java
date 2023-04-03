package med.saudemais.api.controller;

import med.saudemais.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //OBS: Se atentar a métodos e parâmetros.
    // Aqui como estou fazendo um Post para a a web, deve utilizar o @PostMapping, depois dentro do método devo passar um parametro de @Request body, para que o Json seja carregado no terminal, traduzindo ele saiba de onde pegar o Json.
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico data) {
        System.out.println(data);
    }

}
