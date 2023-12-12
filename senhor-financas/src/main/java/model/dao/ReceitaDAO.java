package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.ReceitaVO;

public class ReceitaDAO {

	public ReceitaVO cadastrarReceitaDAO(ReceitaVO receitaVO) {
	    String query = "INSERT INTO receita (idusuario, descricao, valor, datareceita) VALUES (?, ?, ?, ?)";
	    Connection conn = Banco.getConnection();
	    PreparedStatement pstmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

	    try {
	        pstmt.setInt(1, receitaVO.getIdusuario());
	        pstmt.setString(2, receitaVO.getDescricao());
	        pstmt.setDouble(3, receitaVO.getValor());
	        pstmt.setObject(4, receitaVO.getDatareceita());

	        int affectedRows = pstmt.executeUpdate();
	        if (affectedRows > 0) {
	            ResultSet resultado = pstmt.getGeneratedKeys();
	            if (resultado.next()) {
	                receitaVO.setIdreceita(resultado.getInt(1));
	            }
	        }
	    } catch (SQLException erro) {
	        System.out.println("\nErro ao executar a query do método cadastrarReceitaDAO");
	        System.out.println("Erro: " + erro.getMessage());
	    } finally {
	        Banco.closeStatement(pstmt);
	        Banco.closeConnection(conn);
	    }
	    return receitaVO;
	}

	
	public ArrayList<ReceitaVO> consultarTodasReceitasDAO(int idusuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		ResultSet resultado = null;
		ArrayList<ReceitaVO> listaReceitas = new ArrayList<ReceitaVO>();
		String query = "SELECT idreceita, descricao, valor, datareceita FROM receita WHERE idusuario=" + idusuario;
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				ReceitaVO receita = new ReceitaVO();
				receita.setIdreceita(Integer.parseInt(resultado.getString(1)));
				receita.setDescricao(resultado.getString(2));
				receita.setValor(Double.parseDouble(resultado.getString(3)));
				String dataReceitaStr = resultado.getString(4);
	            LocalDateTime dataReceita = LocalDateTime.parse(dataReceitaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	            receita.setDatareceita(dataReceita);
	            receita.setIdusuario(idusuario);
				listaReceitas.add(receita);
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do método consultarTodasReceitasDAO");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaReceitas;
	}
	
	public ReceitaVO consultarReceitaDAO(int idreceita) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ReceitaVO receita = new ReceitaVO();
		String query = "SELECT idreceita, descricao, valor, datareceita FROM receita WHERE idreceita =" + idreceita;
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				receita.setIdreceita(Integer.parseInt(resultado.getString(1)));
				receita.setDescricao(resultado.getString(2));
				receita.setValor(Double.parseDouble(resultado.getString(3)));
				String dataReceitaStr = resultado.getString(4);
	            LocalDateTime dataReceita = LocalDateTime.parse(dataReceitaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	            receita.setDatareceita(dataReceita);
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do método consultarReceitaDAO");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return receita;
	}
	
	public boolean atualizarReceitaDAO(ReceitaVO receitaVO) {
	    Connection conn = Banco.getConnection();
	    PreparedStatement pstmt = null;
	    boolean retorno = false;

	    String query = "UPDATE receita SET descricao = ?, valor = ?, datareceita = ? WHERE idreceita = ?";
	    try {
	        pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, receitaVO.getDescricao());
	        pstmt.setDouble(2, receitaVO.getValor());
	        pstmt.setObject(3, receitaVO.getDatareceita());
	        pstmt.setInt(4, receitaVO.getIdreceita());

	        if (pstmt.executeUpdate() == 1) {
	            retorno = true;
	        }
	    } catch (SQLException erro) {
	        System.out.println("\nErro ao executar a query do método atualizarReceitaDAO");
	        System.out.println("Erro: " + erro.getMessage());
	    } finally {
	        Banco.closeStatement(pstmt);
	        Banco.closeConnection(conn);
	    }
	    return retorno;
	}

	
	public boolean excluirReceitaDAO(int idreceita) {
	    Connection conn = Banco.getConnection();
	    PreparedStatement pstmt = null;
	    boolean retorno = false;

	    String query = "DELETE FROM receita WHERE idreceita = ?";
	    try {
	        pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, idreceita);

	        if (pstmt.executeUpdate() == 1) {
	            retorno = true;
	        }
	    } catch (SQLException erro) {
	        System.out.println("\nErro ao executar a query do método excluirReceitaDAO");
	        System.out.println("Erro: " + erro.getMessage());
	    } finally {
	        Banco.closeStatement(pstmt);
	        Banco.closeConnection(conn);
	    }
	    return retorno;
	}
}
