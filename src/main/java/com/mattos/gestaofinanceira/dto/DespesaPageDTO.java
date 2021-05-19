package com.mattos.gestaofinanceira.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mattos.gestaofinanceira.domain.enums.Situacao;

public class DespesaPageDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nomeDespesa;
	private String favorecido;
	private String formaPagamento;
	private String meioPagamento;

	@JsonFormat(pattern = "MM/yyyy")
	private Date mesReferencia;

	private Integer situacao;


	public DespesaPageDTO() {

	}

	public String getNomeDespesa() {
		return nomeDespesa;
	}

	public void setNomeDespesa(String nomeDespesa) {
		this.nomeDespesa = nomeDespesa;
	}

	public String getFavorecido() {
		return favorecido;
	}

	public void setFavorecido(String favorecido) {
		this.favorecido = favorecido;
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

	public Date getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(Date mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public Situacao getSituacao() {
		return Situacao.toEnum(situacao);
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao.getCod();
	}
	

	@Override
	public String toString() {
		return "DespesaPageDTO [nomeDespesa=" + nomeDespesa + ", favorecido=" + favorecido + ", formaPagamento="
				+ formaPagamento + ", meioPagamento=" + meioPagamento + ", mesReferencia=" + mesReferencia
				+ ", situacao=" + situacao + "]";
	}
}
