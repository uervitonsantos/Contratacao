/**
 * 
 */
package com.contratacao.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author uerviton-santos
 *
 */

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pessoa")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;

	@NotBlank(message = "Nome não foi informado")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
	@Column(name = "NOME", nullable = false, length = 20)
	private String nome;

	@NotBlank(message = "Sobrenome não foi informado")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do sobrenome deve ser maiúscula")
	@Column(name = "SOBRENOME", nullable = false, length = 50)
	private String sobrenome;

	@NotBlank(message = "CPF é obrigatório")
	@CPF(message = "CPF invalido")
	@Column(name = "CPF", unique = true, nullable = false, length = 12)
	private String cpf;

	@NotNull(message = "A data de nascimento é obrigatória. O Cliente não foi adicionado à lista")
	@Column(name = "DATA_NASCIMENTO", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	private Calendar dataNascimento;
	
	@JsonIgnore
	private ZoneId ZONEID = ZoneId.of("America/Sao_Paulo");
	
	
	//Metodo para realizar o calculo da idade dos candidatos
	public Integer getIdade() {

		Integer idade = 0;
		LocalDate dataHoje = LocalDate.now();
		if (getDataNascimento() != null) {
		LocalDate dtNacimento = ZonedDateTime.ofInstant(getDataNascimento().toInstant(), ZONEID).toLocalDate();
		Period dif = dtNacimento.until(dataHoje);
		idade = dif.getYears();
		}
		return idade;

		}

}
