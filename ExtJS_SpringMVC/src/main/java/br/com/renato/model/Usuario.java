package br.com.renato.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Adiciona @Entity para informar que essa classe é uma entidade do banco
@Entity
//Informa o nome da tabela no banco
@Table(name="usuario")
public class Usuario {

	@Id // Chave primária e valor gerado automaticamente (através de um gerador de sequências do postgres)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq_gen")
	@SequenceGenerator(name = "usuario_seq_gen", sequenceName = "usuario_id_seq", allocationSize = 1 )
	@Column(name = "id") // Nome da coluna no banco
	private long id;
	@NotNull // @NotNull para não deixar valores nulos serem inseridos
	private String nome;
	@NotNull
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
