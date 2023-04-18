package med.saudemais.api.controller;

import med.saudemais.api.domain.paciente.Paciente;
import med.saudemais.api.domain.paciente.PacienteRepository;
import med.saudemais.api.domain.paciente.RecordDadosCadastroPaciente;
import med.saudemais.api.domain.paciente.RecordDadosListagemPacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody RecordDadosCadastroPaciente data) {
        repository.save(new Paciente(data));
    }

    /*
    @GetMapping
    public Page<RecordDadosListagemPacientes> listar (@PageableDefault(size = 10, sort = {"nome"})Pageable paginator){
        return repository.findAllByAtivoTrue(paginator).map(RecordDadosListagemPacientes::new);
    }
    */

    @GetMapping
    public List<RecordDadosListagemPacientes> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginator) {
        return repository.findAll(paginator).map(RecordDadosListagemPacientes::new).toList();
    }

    @PutMapping
    public void atualizar() {

    }

    /*
    @DeleteMapping("/{id}")
    public void deletar(PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.deletar();
    }
    */
}
