package br.edu.infnet.apiendereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apiendereco.model.domain.Endereco;
import br.edu.infnet.apiendereco.model.service.EnderecoService;

@Component
public class EnderecoLoader implements ApplicationRunner {

	@Autowired
	private EnderecoService enderecoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		String cep = "22770-102";

		Endereco endereco = new Endereco();
		try {
			endereco.setCep(cep);
			endereco.setBairro("Pechincha");
			endereco.setLocalidade("Rio de Janeiro");
			endereco.setLogradouro("Rua Retiro dos Artistas");
			endereco.setComplemento("BL1 AP411");
			endereco.setUf("RJ");

			enderecoService.incluir(endereco);
			System.out.println("Gravacao do endereco realizada com sucesso!!!");

		} catch (Exception e) {
			System.out.println("Gravacao do endereco nao realizada!!!");

			Endereco enderecoBusca = enderecoService.obterPorCep(cep);
			System.out.println("Endereco recuperado atraves do cep [" + cep + "]");
			System.out.printf("%s - %s, %s %s - %s\n", enderecoBusca.getLogradouro(), enderecoBusca.getComplemento(),
					enderecoBusca.getBairro(), enderecoBusca.getLocalidade(), enderecoBusca.getUf());

			try {
				endereco.setCep("22745-004");
				enderecoService.incluir(endereco);
			} catch (Exception e2) {
				System.out.println("Gravacao do endereco nao realizada!!!");
			}

			for (Endereco end : enderecoService.obterLista()) {
				System.out.printf("[%s] %s - %s, %s %s - %s\n", end.getCep(), end.getLogradouro(), end.getComplemento(),
						end.getBairro(), end.getLocalidade(), end.getUf());
			}

//			System.out.println("Endereco excluido atraves do cep [" + enderecoBusca.getCep() + "]");
//			enderecoService.excluir(enderecoBusca.getId());

		}
	}

}
