package med.saudemais.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.saudemais.api.endereco.Endereco;

@Table(name = "medicos")        // Estou definindo o nome da tabela como medicos
@Entity(name= "Medico")         // Estou falando que a entidade se chama Medico
@Getter         // Lombok vai gerar os métodos Getters e Setters
@NoArgsConstructor      //Vai gerar um construtor sem argumentos, pois a JPA exige para todas as entidades
@AllArgsConstructor     // Vai ter um construtor que recebe todos os campos passados.
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)            // Estou gerando um id para cada identidade nova cadastrada
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)            // Estou usando o tipo ENUM para restringir e armazenar Strings
    private Especialidade especialidade;
    @Embedded           // Vai ter atributos próprios porém irá ficar na mesma tabela que medicos.
    private Endereco endereco;
}
