package med.saudemais.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.saudemais.api.domain.endereco.Endereco;

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
    private Boolean ativo;


    public Medico(DadosCadastroMedico data) {
        this.ativo = true;
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.crm = data.crm();
        this.especialidade = data.especialidade();
        this.endereco = new Endereco(data.endereco());
    }

    // Preciso fazer um contrutor no endereço pois coloquei ele também com DadosEndereço, então ele não está reconhecendo.
    // MUITO IMPORTANTE! Sempre que precisar criar um contrutor em determinado lugar, precisar definir oque ele possui dentro da classe raiz dele.


    public void atualizarInformacoes(DadosAtualizaMedico data) {
        if(data.email() != null) {
            this.email = data.email();
        }
        if (data.telefone() != null) {
            this.telefone = data.telefone();
        }
        if (data.endereco() != null) {
            this.endereco.atualizarInformacoes(data.endereco());
        }

    }


    public void excluir() {
        this.ativo = false;
    }
}
