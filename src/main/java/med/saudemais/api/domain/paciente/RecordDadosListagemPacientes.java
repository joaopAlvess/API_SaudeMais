package med.saudemais.api.domain.paciente;

public record RecordDadosListagemPacientes(
        Long id,
        String nome,
        String email,
        String cpf
) {

    // Criando o contrutor de qual estou chamando para a lsitagem desse seguinte comando:

    public RecordDadosListagemPacientes(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
