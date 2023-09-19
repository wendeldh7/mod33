package br.com.gomes.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author wendel.gomes
 *
 */
@Entity
@Table(name = "TB_ACESSORIO")
public class Matricula {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="acessorio_seq")
	@SequenceGenerator(name="acessorio_seq", sequenceName="sq_acessorio", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "CODIGO", length = 10, nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "DATA_ACESSORIO", nullable = false)
	private Instant dataMatricula;
	
	@Column(name = "valor", nullable = false)
	private Double valor;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "id_carro_fk", 
		foreignKey = @ForeignKey(name = "fk_carro_acessorio"), 
		referencedColumnName = "id", nullable = false
	)
	private Carro curso;
	
	@OneToOne
	@JoinColumn(name = "id_carro_fk", 
		foreignKey = @ForeignKey(name = "fk_carro_acessorio"), 
		referencedColumnName = "id", nullable = false
	)	
	private Carro carro;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Instant getDataAcessorio() {
		return dataAcessorio;
	}

	public void setDataAcessorio(Instant dataAcessorio) {
		this.dataAcessorio = dataAcessorio;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Curso getCarro() {
		return carro;
	}

	public void setCurso(Carro carro) {
		this.carro = carro;
	}

	public Carro getAluno() {
		return aluno;
	}

	public void setAluno(Carro carro) {
		this.carro = carro;
	}
	

}
