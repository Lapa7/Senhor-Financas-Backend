package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dto.RelatorioDTO;

public class RelatorioDAO {

	public ArrayList<RelatorioDTO> consultarRelatorioDAO(int idusuario, int ano){
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		ResultSet resultado = null;
		ArrayList<RelatorioDTO> listaMeses = new ArrayList<RelatorioDTO>();
		String query = "SELECT mes, ano, COALESCE(SUM(total_receitas), 0) AS total_receitas, " +
			    "COALESCE(SUM(total_despesas), 0) AS total_despesas FROM (" +
			    "SELECT MONTH(datareceita) AS mes, YEAR(datareceita) AS ano, SUM(valor) AS total_receitas, 0 AS total_despesas " +
			    "FROM receita WHERE YEAR(datareceita) = " + ano + " AND idusuario = " + idusuario +
			    " GROUP BY MONTH(datareceita), YEAR(datareceita) " +
			    "UNION ALL " +
			    "SELECT MONTH(datavencimento) AS mes, YEAR(datavencimento) AS ano, 0 AS total_receitas, SUM(valor) AS total_despesas " +
			    "FROM despesa WHERE YEAR(datavencimento) = " + ano + " AND idusuario = " + idusuario +
			    " GROUP BY MONTH(datavencimento), YEAR(datavencimento)" +
			    ") AS subquery GROUP BY mes, ano ORDER BY ano, mes;";


		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				RelatorioDTO mes = new RelatorioDTO();
				mes.setMes(Integer.parseInt(resultado.getString(1)));
				mes.setAno(Integer.parseInt(resultado.getString(2)));
				mes.setTotalReceitas(Double.parseDouble(resultado.getString(3)));
				mes.setTotalDespesas(Double.parseDouble(resultado.getString(4)));
				listaMeses.add(mes);
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do método consultarRelatorioDAO");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaMeses;
	}
}
