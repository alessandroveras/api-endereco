package br.edu.infnet.apiendereco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiendereco.model.domain.Endereco;
import br.edu.infnet.apiendereco.model.service.EnderecoService;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping(value = "/listar")
	public List<Endereco> obterLista() {
		return enderecoService.obterLista();
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Endereco endereco) {
		enderecoService.incluir(endereco);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		enderecoService.excluir(id);
	}

	@GetMapping(value = "/{cep}") 
	public Endereco obterPorCep(@PathVariable String cep) {
		return enderecoService.obterPorCep(cep);
	}

	

}
