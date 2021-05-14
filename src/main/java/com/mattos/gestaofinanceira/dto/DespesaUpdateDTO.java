package com.mattos.gestaofinanceira.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mattos.gestaofinanceira.domain.enums.Situacao;

public class DespesaUpdateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

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

	public DespesaUpdateDTO() {

	}

	public DespesaUpdateDTO(Integer id, String nomeDespesa, String favorecido, String formaPagamento,
			String meioPagamento, Date mesReferencia, Date dataVencimento, 
			Date dataPagamento, Double valorDespesa, Double valorPago, Situacao situacao) {
		this.id = id;
		this.nomeDespesa = nomeDespesa;
		this.favorecido = favorecido;
		this.formaPagamento = formaPagamento;
		this.meioPagamento = meioPagamento;
		this.mesReferencia = mesReferencia;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valorDespesa = valorDespesa;
		this.valorPago = valorPago;
		this.situacao = (situacao == null) ? null : situacao.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
