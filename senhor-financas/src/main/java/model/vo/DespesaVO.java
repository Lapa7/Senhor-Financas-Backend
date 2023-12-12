package model.vo;

import java.time.LocalDateTime;

public class DespesaVO {

	private int iddespesa;
	private int idusuario;
	private String descricao;
	private double valor;
	private LocalDateTime datavencimento;
	private LocalDateTime datapagamento;
	
	public DespesaVO(int iddespesa, int idusuario, String descricao, double valor, LocalDateTime datavencimento,
			LocalDateTime datapagamento) {
		super();
		this.iddespesa = iddespesa;
		this.idusuario = idusuario;
		this.descricao = descricao;
		this.valor = valor;
		this.datavencimento = datavencimento;
		this.datapagamento = datapagamento;
	}

	public DespesaVO() {
		super();
	}

	public int getIddespesa() {
		return iddespesa;
	}

	public void setIddespesa(int iddespesa) {
		this.iddespesa = iddespesa;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDatavencimento() {
		return datavencimento;
	}

	public void setDatavencimento(LocalDateTime datavencimento) {
		this.datavencimento = datavencimento;
	}

	public LocalDateTime getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(LocalDateTime datapagamento) {
		this.datapagamento = datapagamento;
	}
}
