package com.mattos.gestaofinanceira.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mattos.gestaofinanceira.domain.enums.Situacao;

@Entity
public class Receita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Campo obrigatório")
	private String nomeReceita;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataAlteracao;

	private String origem;

	@NotNull(message = "Campo obrigatório")
	@JsonFormat(pattern = "MM/yyyy")
	private Date mesReferencia;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCredito;

	@NotNull(message = "Campo obrigatório")
	private Double valorReceita;

	private String formaPagamento;
	private String meioPagamento;

	private Double valorPago;

	private Integer situacao;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserAccount user;

	public Receita() {

	}

	public Receita(Integer id, String nomeReceita, Date dataCredito, String origem, Date mesReferencia, Double valorReceita, String meioPagamento, String formaPagamento, Double valorPago,
			UserAccount user, Situacao situacao) {
		this.id = id;
		this.nomeReceita = nomeReceita;
		this.origem = origem;
		this.dataCredito = dataCredito;
		this.formaPagamento = formaPagamento;
		this.meioPagamento = meioPagamento;
		this.mesReferencia = mesReferencia;
		this.valorReceita = valorReceita;
		this.valorPago = valorPago;
		this.user = user;
		this.situacao = (situacao == null) ? null : situacao.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeReceita() {
		return nomeReceita;
	}

	public void setNomeReceita(String nomeReceita) {
		this.nomeReceita = nomeReceita;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Date getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(Date mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public Date getDataCredito() {
		return dataCredito;
	}

	public void setDataCredito(Date dataCredito) {
		this.dataCredito = dataCredito;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getMeioPagamento() {
		return meioPagamento;
	}

	public void setMeioPagamento(String meioPagamento) {
		this.meioPagamento = meioPagamento;
	}

	public Double getValorReceita() {
		return valorReceita;
	}

	public void setValorReceita(Double valorReceita) {
		this.valorReceita = valorReceita;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Situacao getSituacao() {
		return Situacao.toEnum(situacao);
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao.getCod();
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receita other = (Receita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Receita [id=" + id + ", nomeReceita=" + nomeReceita + ", dataAlteracao=" + dataAlteracao + ", origem="
				+ origem + ", mesReferencia=" + mesReferencia + ", dataCredito=" + dataCredito + ", valorReceita="
				+ valorReceita + ", formaPagamento=" + formaPagamento + ", meioPagamento=" + meioPagamento
				+ ", valorPago=" + valorPago + ", situacao=" + situacao + ", user=" + user + "]";
	}
	
	

}
