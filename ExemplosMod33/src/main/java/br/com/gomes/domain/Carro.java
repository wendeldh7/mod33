/**
 * 
 */
package br.com.gomes.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author wendel.gomes
 *
 */
@Entity
@Table(name = "TB_CARRO")
public class Carro {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carro_seq")
	@SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "CODIGO", length = 10, nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "NOME", length = 10, nullable = false)
	private String nome;
	
	@OneToOne(mappedBy = "carro")
	private Matricula matricula;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "TB_CARRO_MARCA", 
        joinColumns = { @JoinColumn(name = "id_carro_fk") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_marca_fk") }
    )
	private List<marca> marcas;
	
	public Carro() {
		this.marcas = new ArrayList<marca>();
	}

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Matricula getMatricula() {
		return acessorio;
	}

	public void setMatricula(Acessorio acessorio) {
		this.acessorio = acessorio;
	}

	public List<marca> getMarcas() {
		return computadores;
	}

	public void setMarcas(List<marca> marcas) {
		this.marcas = marcas;
	}
	
	public void add(marca marcas) {
		this.computadores.add(marcas);
	}
	
}
