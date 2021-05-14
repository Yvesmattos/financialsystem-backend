package com.mattos.gestaofinanceira.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserAccount implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Email
	@Column(unique = true)
	private String email;

	@NotNull(message = "Campo obrigatório")
	private String nome;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Despesa> despesas = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Receita> receitas = new ArrayList<>();

	public UserAccount() {

	}

	public UserAccount(Integer id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public List<Despesa> getDespesas() {
		return despesas;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

}
