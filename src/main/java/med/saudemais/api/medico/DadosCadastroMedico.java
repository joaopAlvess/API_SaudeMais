package med.saudemais.api.medico;

import med.saudemais.api.endereco.DadosEndereco;

//Aqui estou passando parametrô por parametro em que devo receber na requisição, assim depois poderei chama-los chamando apenas o método especifico (exemplo: Chamar somente o nome e o crm)
//Repare que para estou fazendo a criação de um Enum, pois eu possuo propriedades pré definidas para o campo de Especialidades, dito isso preciso criar o enum em outro lugar e depois chamo-lo para ca..
//Já na parte de endereço, estou utilizando um novo (record) pois depois possivelmente irei aproveitalo em outros controllers.
public record DadosCadastroMedico(String nome, String email, String crm, String telefone, Especialidade especialidade, DadosEndereco endereco) {
}
