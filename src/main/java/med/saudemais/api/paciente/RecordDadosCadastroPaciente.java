package med.saudemais.api.paciente;

import med.saudemais.api.endereco.DadosEndereco;

public record RecordDadosCadastroPaciente(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {
}
