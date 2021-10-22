/**
 * 
 */
package com.contratacao.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "Vaga")
public class Vaga implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VAGA", updatable = false, nullable = false)
	private Long id_vaga;

	@NotBlank(message = "Titulo não foi informado")
	@Column(name = "TITULO", nullable = false, length = 100)
	private String titulo;

	@NotBlank(message = "Descrição não foi informado")
	@Column(name = "DESCRICAO", nullable = false, length = 600)
	private String descricao;

	@NotNull(message = "Quantidade não foi informado")
	@Column(name = "QUANTIDADE", nullable = false, length = 3)
	private int quantidadeVagas;

	@NotNull(message = "Quantidade maxima de candidatos não foi informada")
	@Column(name = "MAXIMO_CADIDATO", nullable = false, length = 3)
	private int maximoCandidatos;

	@NotNull(message = "Data não foi informado")
	@Column(name = "DATA", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pessoa_id")
	@JsonBackReference
	private Pessoa pessoa;

}
