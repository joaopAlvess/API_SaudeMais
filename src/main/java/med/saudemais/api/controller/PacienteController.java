package med.saudemais.api.controller;

import med.saudemais.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody RecordDadosCadastroPaciente data) {
        repository.save(new Paciente(data));
    }

    @PutMapping
    public void atualizar() {

    }

    @DeleteMapping
    public void deletar() {

    }

}
