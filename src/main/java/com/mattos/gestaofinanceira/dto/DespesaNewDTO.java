package com.mattos.gestaofinanceira.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mattos.gestaofinanceira.domain.enums.Situacao;

public class DespesaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Campo obrigatório")
	private String nomeDespesa;

	@NotEmpty(message = "Campo obrigatório")
	private String favorecido;
	private String formaPagamento;
	private String meioPagamento;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataAlteracao;

	@NotNull(message = "Campo obrigatório")
	@JsonFormat(pattern = "MM/yyyy")
	private Date mesReferencia;

	@NotNull(message = "Campo obrigatório")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimento;


	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;

	@NotNull(message = "Campo obrigatório")
	private Double valorDespesa;

	private Double valorPago;
	
	private Integer situacao;

	private Integer userId;

	public DespesaNewDTO() {

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

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(Double valorDespesa) {
		this.valorDespesa = valorDespesa;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "DespesaNewDTO [nomeDespesa=" + nomeDespesa + ", favorecido=" + favorecido + ", formaPagamento="
				+ formaPagamento + ", meioPagamento=" + meioPagamento + ", dataAlteracao=" + dataAlteracao
				+ ", mesReferencia=" + mesReferencia + ", dataVencimento=" + dataVencimento + ", dataPagamento="
				+ dataPagamento + ", valorDespesa=" + valorDespesa + ", valorPago=" + valorPago + ", situacao="
				+ situacao + ", userId=" + userId + "]";
	}
	
	

}
