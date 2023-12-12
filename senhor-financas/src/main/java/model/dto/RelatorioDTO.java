package model.dto;

public class RelatorioDTO {
	
	private int ano;
	private int mes;
	private double totalReceitas;
	private double totalDespesas;
	
	public RelatorioDTO(int ano, int mes, double totalReceitas, double totalDespesas) {
		super();
		this.ano = ano;
		this.mes = mes;
		this.totalReceitas = totalReceitas;
		this.totalDespesas = totalDespesas;
	}

	public RelatorioDTO() {
		super();
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public double getTotalReceitas() {
		return totalReceitas;
	}

	public void setTotalReceitas(double totalReceitas) {
		this.totalReceitas = totalReceitas;
	}

	public double getTotalDespesas() {
		return totalDespesas;
	}

	public void setTotalDespesas(double totalDespesas) {
		this.totalDespesas = totalDespesas;
	}
}
