package med.saudemais.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.saudemais.api.domain.endereco.DadosEndereco;

public record DadosAtualizaMedico(
        @NotNull
        Long id,
        String email,
        String telefone,
        DadosEndereco endereco) {
}
