package med.saudemais.api.medico;

import jakarta.validation.constraints.NotNull;
import med.saudemais.api.endereco.DadosEndereco;

public record DadosAtualizaMedico(
        @NotNull
        Long id,
        String email,
        String telefone,
        DadosEndereco endereco) {
}
