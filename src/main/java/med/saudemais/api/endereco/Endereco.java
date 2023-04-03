package med.saudemais.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable         // Utilizei pq estou fazendo como Embedded na tabela de (medicos)
@Getter         // Explicação no arquivo (MEDICO)
@NoArgsConstructor          // Explicação no arquivo (MEDICO)
@AllArgsConstructor         // Explicação no arquivo (MEDICO)
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
}