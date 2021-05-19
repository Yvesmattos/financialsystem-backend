package com.mattos.gestaofinanceira.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mattos.gestaofinanceira.domain.enums.Situacao;

public class ReceitaPageDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nomeReceita;
	private String origem;
	private String formaPagamento;
	private String meioPagamento;

	@JsonFormat(pattern = "MM/yyyy")
	private Date mesReferencia;

	private Integer situacao;


	public ReceitaPageDTO() {

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
		return "ReceitaPageDTO [nomeReceita=" + nomeReceita + ", origem=" + origem + ", formaPagamento="
				+ formaPagamento + ", meioPagamento=" + meioPagamento + ", mesReferencia=" + mesReferencia
				+ ", situacao=" + situacao + "]";
	}
}
