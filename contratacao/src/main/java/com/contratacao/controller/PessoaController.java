/**
 * 
 */
package com.contratacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.contratacao.model.Pessoa;
import com.contratacao.service.PessoaService;

/**
 * @author uerviton-santos
 *
 */

@Controller
@RequestMapping("/api")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@RequestMapping("/pessoa")
	public String pessoa() {
		return "pessoa";
	}

	@RequestMapping(value = "/pessoa", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("pessoa");
		List<Pessoa> pessoa = pessoaService.listaTodos();
		mv.addObject("pessoa", pessoa);
		return mv;
	}

	// METODO QUE LISTA TODOS OS CANDIDATOS. TESTE NO POSTMAN
	/*
	 * @GetMapping(value = "/pessoa/list")
	 * 
	 * @ResponseStatus(HttpStatus.OK) public List<Pessoa> lista() { return
	 * pessoaService.listaTodos(); }
	 */

	// METODO QUE LISTA OS CANDIDATOS POR Id. TESTE NO POSTMAN
	@GetMapping(value = "/pessoa/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Pessoa> buscarById(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.buscaPorId(id);
		return ResponseEntity.ok().body(pessoa);
	}

	// METODO QUE SALVA OS DADOS DOS CANDIDATOS. TESTE NO POSTMAN
	@RequestMapping(value = "/pessoa", method = RequestMethod.POST)
	public ResponseEntity<Pessoa> salvar(Pessoa pessoa) {
		return pessoaService.salva(pessoa);

	}

	// METODO QUE ATUALIZA OS DADOS DOS CANDIDATOS POR ID. TESTE NO POSTMAN
	@PutMapping("/pessoa/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Pessoa atualizar(@RequestBody Pessoa newPessoa, @PathVariable Long id) {
		return pessoaService.atualiza(newPessoa, id);

	}

	// METODO QUE EXCLUI DOS DADOS DO CANDIDATOS. BUSCA REALIZADA POR Id. TESTE NO
	// POSTMAN
	@DeleteMapping("/pessoa/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		pessoaService.exclui(id);

	}

}
