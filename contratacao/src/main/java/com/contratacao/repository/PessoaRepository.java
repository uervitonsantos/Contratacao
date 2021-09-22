/**
 * 
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
	
	@Query("select count(*) from Pessoa")
	int countQuantitPessoa();
}
