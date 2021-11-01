/**
 * 
 */
package com.contratacao.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@Column(name = "DESCRICAO", nullable = false, length = 2000)
	private String descricao;

	@NotNull(message = "Data não foi informado")
	@Column(name = "DATA", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;

	@NotNull(message = "Data de validade do anuncio não foi informado")
	@Column(name = "DATA_VALIDADE", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar data_validade;


}
