/**
 * CLASSE (PESSOAREPOSITORY) EXTENDE A CLASSE (JPAREPOSITORY) QUE 
 * FORNECE OS METODOS PARA COMTROLE DAS TRANSAÇÕES COM DO BANCO 
 * DE DADOS 
 */
package com.contratacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.contratacao.model.Pessoa;

/**
 * @author uerviton-santos
 *
 */

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	//QUERY PERSONALIZADA PARA CONTAR AS LINHAS DA TABELA PESSOA
	@Query("select count(*) from Pessoa")
	int countQuantitPessoa();
}
