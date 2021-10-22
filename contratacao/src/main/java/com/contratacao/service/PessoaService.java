/**
 CLASE QUE TEM COMO RESPONSABILIDADE GERENCIA AS REGRAS DE NEGOCIOS
 */
package com.contratacao.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.contratacao.model.Pessoa;
import com.contratacao.model.Vaga;
import com.contratacao.repository.PessoaRepository;

/**
 * @author uerviton-santos
 *
 */

@Service
public class PessoaService {
	
	
	@Autowired
	PessoaRepository pessoaRepository;

	//Metodo utilizado para realizar a persistencia dos dados na tabela Pessoa
	public ResponseEntity<Pessoa> salva(@Valid Pessoa pessoa) {
		
		Vaga vaga = new Vaga();
		
		try {
			if (pessoaRepository.countQuantitPessoa() >= 100) {
				System.out.println("JÁ HÁ CADASTRADOS 10 PESSOAS");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		pessoaRepository.save(pessoa);
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}
	
	
	//Metodo utilizado para realizar a busca por ID
	public Pessoa buscaPorId(@PathVariable Long id) {
		return pessoaRepository.findById(id).get();
	}

	//Metodo para realizar a listagem dos dados da tabela Pessoa
	public List<Pessoa> listaTodos() {
		return pessoaRepository.findAll();

	}

	//Metodo utilizado para atualizar os dados na tabela Pessoa
	public Pessoa atualiza(@RequestBody Pessoa newpessoa, @PathVariable Long id) {

		return pessoaRepository.findById(id).map(pessoa -> {
			pessoa.setId_pessoa(newpessoa.getId_pessoa());
			pessoa.setNome(newpessoa.getNome());
			pessoa.setSobrenome(newpessoa.getSobrenome());
			pessoa.setCpf(newpessoa.getCpf());
			pessoa.setDataNascimento(newpessoa.getDataNascimento());

			return pessoaRepository.save(pessoa);
		}).orElseGet(() -> {
			newpessoa.setId_pessoa(id);
			return pessoaRepository.save(newpessoa);
		});
	}

	//Metodo utilizado para excluir os dados da tabela Pessoa
	public void exclui(@PathVariable Long id) {
		pessoaRepository.deleteById(id);

	}
}
