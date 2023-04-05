package med.saudemais.api.medico;

public record DadosListagemMedicos(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
    ) {

    //Declarando um construtor
    public DadosListagemMedicos(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
