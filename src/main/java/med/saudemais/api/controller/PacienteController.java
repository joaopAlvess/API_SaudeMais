package med.saudemais.api.controller;

import med.saudemais.api.paciente.PacienteRepository;
import med.saudemais.api.paciente.RecordDadosCadastroPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody RecordDadosCadastroPaciente data) {
        System.out.println(data);
    }
}
