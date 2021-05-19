package com.mattos.gestaofinanceira.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mattos.gestaofinanceira.domain.enums.Situacao;

public class ReceitaUpdateDTO implements Serializable {
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
	private Date dataTermino;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCredito;

	private String meioPagamento;
	private String formaPagamento;

	@NotNull(message = "Campo obrigatório")
	private Double valorReceita;

	private Double valorPago;

	private Integer situacao;

	public ReceitaUpdateDTO() {

	}

	public ReceitaUpdateDTO(Integer id, String nomeReceita, String origem, Date mesReferencia, Date dataCredito,
			String formaPagamento, String meioPagamento, Double valorReceita, Double valorPago, Situacao situacao) {
		this.id = id;
		this.nomeReceita = nomeReceita;
		this.origem = origem;
		this.meioPagamento = meioPagamento;
		this.formaPagamento = formaPagamento;
		this.dataCredito = dataCredito;
		this.mesReferencia = mesReferencia;
		this.valorReceita = valorReceita;
		this.valorPago = valorPago;
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

	public void setMesReferencia(Date mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Date getMesReferencia() {
		return mesReferencia;
	}

	public Date getDataCredito() {
		return dataCredito;
	}

	public void setDataCredito(Date dataCredito) {
		this.dataCredito = dataCredito;
	}

	public String getMeioPagamento() {
		return meioPagamento;
	}

	public void setMeioPagamento(String meioPagamento) {
		this.meioPagamento = meioPagamento;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
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

	@Override
	public String toString() {
		return "ReceitaUpdateDTO [id=" + id + ", nomeReceita=" + nomeReceita + ", dataAlteracao=" + dataAlteracao
				+ ", origem=" + origem + ", mesReferencia=" + mesReferencia + ", dataTermino=" + dataTermino
				+ ", dataCredito=" + dataCredito + ", meioPagamento=" + meioPagamento + ", formaPagamento="
				+ formaPagamento + ", valorReceita=" + valorReceita + ", valorPago=" + valorPago + ", situacao="
				+ situacao + "]";
	}
}
