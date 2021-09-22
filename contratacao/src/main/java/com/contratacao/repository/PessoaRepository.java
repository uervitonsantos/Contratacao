/**
 * 
 */
package com.contratacao.repository;

import java.util.List;

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
	
	@Query("SELECT p FROM Pessoa p WHERE p.id ='10'")
	List<Pessoa> Pessoa();
}
