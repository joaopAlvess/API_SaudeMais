package med.saudemais.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.saudemais.api.domain.endereco.DadosEndereco;

//Aqui estou passando parametrô por parametro em que devo receber na requisição, assim depois poderei chama-los chamando apenas o método especifico (exemplo: Chamar somente o nome e o crm)
//Repare que para estou fazendo a criação de um Enum, pois eu possuo propriedades pré definidas para o campo de Especialidades, dito isso preciso criar o enum em outro lugar e depois chamo-lo para ca..
//Já na parte de endereço, estou utilizando um novo (record) pois depois possivelmente irei aproveitalo em outros controllers.
public record DadosCadastroMedico(
        @NotBlank    //Fazendo a validação com BinValidation, pacote que está setado no Maven (Para evitar o uso de if, preciso fazer somente as anotações de quais serão as validações que quero colocar
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")       //Com essa anotação, estou fazendo uma epressão regular, o regexp serve para limitar algo, o "\\d" quer dizer que só pode ser (digitos) já o "{4, 6}" significa que os numeros passado devem ser no minimo 4 e no máximo 6
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid DadosEndereco endereco) {       //Valid serve para dizer que vou ter outras validações dentro do Objeto passado, nesse caso preciso definir essas validações lá no campo de DadosEndereco
}
