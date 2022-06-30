package br.edu.infnet.apiendereco.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiendereco.model.domain.Endereco;
import br.edu.infnet.apiendereco.model.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<Endereco> obterLista() {
		return (List<Endereco>) enderecoRepository.findAll();
	}

	public void incluir(Endereco endereco) {
		enderecoRepository.save(endereco);
	}

	public void excluir(Integer id) {
		enderecoRepository.deleteById(id);
	}

	public Endereco obterPorCep(String cep) {
		return enderecoRepository.findByCep(cep);
	}

}
