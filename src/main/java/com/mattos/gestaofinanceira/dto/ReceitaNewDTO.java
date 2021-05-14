package com.mattos.gestaofinanceira.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mattos.gestaofinanceira.domain.enums.Situacao;

public class ReceitaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Campo obrigatório")
	private String nomeReceita;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCredito;

	private String origem;

	private String formaPagamento;
	private String meioPagamento;

	@NotNull(message = "Campo obrigatório")
	@JsonFormat(pattern = "MM/yyyy")
	private Date mesReferencia;

	@NotNull(message = "Campo obrigatório")
	private Double valorReceita;

	private Double valorPago;

	private Double total;

	private Integer situacao;

	private Integer userId;

	public ReceitaNewDTO() {

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

	public Date getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(Date mesReferencia) {
		this.mesReferencia = mesReferencia;
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

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Double getTotal() {
		return total;
	}

	public Situacao getSituacao() {
		return Situacao.toEnum(situacao);
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao.getCod();
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
