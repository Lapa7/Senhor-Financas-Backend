package model.vo;

import java.time.LocalDateTime;

public class ReceitaVO {

	private int idreceita;
	private int idusuario;
	private String descricao;
	private double valor;
	private LocalDateTime datareceita;
	
	public ReceitaVO(int idreceita, int idusuario, String descricao, double valor, LocalDateTime datareceita) {
		super();
		this.idreceita = idreceita;
		this.idusuario = idusuario;
		this.descricao = descricao;
		this.valor = valor;
		this.datareceita = datareceita;
	}

	public ReceitaVO() {
		super();
	}

	public int getIdreceita() {
		return idreceita;
	}

	public void setIdreceita(int idreceita) {
		this.idreceita = idreceita;
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

	public LocalDateTime getDatareceita() {
		return datareceita;
	}

	public void setDatareceita(LocalDateTime datareceita) {
		this.datareceita = datareceita;
	}
}
