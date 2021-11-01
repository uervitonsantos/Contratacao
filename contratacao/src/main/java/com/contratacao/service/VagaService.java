/**
 CLASE QUE TEM COMO RESPONSABILIDADE GERENCIA AS REGRAS DE NEGOCIOS
 */
package com.contratacao.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.contratacao.model.Vaga;
import com.contratacao.repository.VagaRepository;

/**
 * @author uerviton-santos
 *
 */

@Service
public class VagaService {

	@Autowired
	VagaRepository vagaRepository;

	// Metodo utilizado para realizar a persistencia dos dados na tabela Vaga
	public String salva(@Valid Vaga vaga) {
		vaga.setData(LocalDate.now());
		vagaRepository.save(vaga);
		return "redirect:/api/vagas";
	}

	// Metodo utilizado para realizar a busca por ID
	public Vaga buscaPorId(@PathVariable Long id) {
		return vagaRepository.findById(id).get();
	}

	// Metodo para realizar a listagem dos dados da tabela Vaga
	public List<Vaga> listaTodos() {
		return vagaRepository.findAll();
	}

	// Metodo utilizado para atualizar os dados na tabela Vaga
	public Vaga atualiza(@RequestBody Vaga newvaga, @PathVariable Long id) {

		return vagaRepository.findById(id).map(vaga -> {
			vaga.setId_vaga(newvaga.getId_vaga());
			vaga.setTitulo(newvaga.getTitulo());
			vaga.setDescricao(newvaga.getDescricao());
			vaga.setData_validade(newvaga.getData_validade());

			return vagaRepository.save(vaga);
		}).orElseGet(() -> {
			newvaga.setId_vaga(id);
			return vagaRepository.save(newvaga);
		});
	}

	// Metodo utilizado para excluir os dados da tabela Vaga
	public void exclui(@PathVariable Long id) {
		vagaRepository.deleteById(id);

	}
}
