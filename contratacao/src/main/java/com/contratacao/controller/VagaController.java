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

import com.contratacao.model.Vaga;
import com.contratacao.service.VagaService;

/**
 * @author uerviton-santos
 *
 */

@Controller
@RequestMapping("/api")
public class VagaController {

	@Autowired
	VagaService vagaService;

	@RequestMapping("/vagas")
	public String vagas() {
		return "vagas";
	}

	@RequestMapping(value = "/vagas", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("vagas");
		List<Vaga> vagas = vagaService.listaTodos();
		mv.addObject("vagas", vagas);
		return mv;
	}

	// METODO QUE LISTA AS VAGAS POR ID. TESTE NO POSTMAN
	@GetMapping(value = "/vagas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Vaga> buscarById(@PathVariable Long id) {
		Vaga vaga = vagaService.buscaPorId(id);
		return ResponseEntity.ok().body(vaga);
	}

	// METODO QUE SALVA OS DADOS DAS VAGAS. TESTE NO POSTMAN
	@RequestMapping(value = "/vagas", method = RequestMethod.POST)
	public ResponseEntity<Vaga> salvar(Vaga vaga) {
		return vagaService.salva(vaga);

	}

	// METODO QUE ATUALIZA OS DADOS DAS VAGAS POR ID. TESTE NO POSTMAN
	@PutMapping("/vagas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Vaga atualizar(@RequestBody Vaga newVaga, @PathVariable Long id) {
		return vagaService.atualiza(newVaga, id);

	}

	// METODO QUE EXCLUI DOS DADOS DA VAGA. BUSCA REALIZADA POR Id. TESTE NO
	// POSTMAN
	@DeleteMapping("/Vagas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		vagaService.exclui(id);

	}

}
