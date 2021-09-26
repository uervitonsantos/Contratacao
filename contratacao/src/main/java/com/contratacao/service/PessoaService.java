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
import com.contratacao.repository.PessoaRepository;

/**
 * @author uerviton-santos
 *
 */

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	public ResponseEntity<Pessoa> salva(@Valid Pessoa pessoa) {
		try {
			if (pessoaRepository.countQuantitPessoa() >= 10) {
				System.out.println("JÁ HÁ CADASTRADOS 10 PESSOAS");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		pessoaRepository.save(pessoa);
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}

	public Pessoa buscaPorId(@PathVariable Long id) {
		return pessoaRepository.findById(id).get();

	}

	public List<Pessoa> listaTodos() {
		return pessoaRepository.findAll();

	}

	public Pessoa atualiza(@RequestBody Pessoa newpessoa, @PathVariable Long id) {

		return pessoaRepository.findById(id).map(pessoa -> {
			pessoa.setId(newpessoa.getId());
			pessoa.setNome(newpessoa.getNome());
			pessoa.setSobrenome(newpessoa.getSobrenome());
			pessoa.setCpf(newpessoa.getCpf());
			pessoa.setDataNascimento(newpessoa.getDataNascimento());

			return pessoaRepository.save(pessoa);
		}).orElseGet(() -> {
			newpessoa.setId(id);
			return pessoaRepository.save(newpessoa);
		});
	}

	public void exclui(@PathVariable Long id) {
		pessoaRepository.deleteById(id);

	}
}
