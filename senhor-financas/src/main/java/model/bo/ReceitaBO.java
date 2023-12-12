package model.bo;

import java.util.ArrayList;

import model.dao.ReceitaDAO;
import model.vo.ReceitaVO;

public class ReceitaBO {

	public ReceitaVO cadastrarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		receitaDAO.cadastrarReceitaDAO(receitaVO);
		return receitaVO;
	}
	
	public ArrayList<ReceitaVO> consultarTodasReceitasBO(int idusuario){
		ReceitaDAO receitaDAO = new ReceitaDAO();
		ArrayList<ReceitaVO> listaReceitasVO = receitaDAO.consultarTodasReceitasDAO(idusuario);
		return listaReceitasVO;
	}
	
	public ReceitaVO consultarReceitaBO(int idreceita) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		ReceitaVO receita = receitaDAO.consultarReceitaDAO(idreceita);
		return receita;
	}
	
	public boolean atualizarReceitaBO(ReceitaVO receitaVO) {
		boolean resultado = false;
		ReceitaDAO receitaDAO = new ReceitaDAO();
		resultado = receitaDAO.atualizarReceitaDAO(receitaVO);
		return resultado;
	}
	
	public boolean excluirReceitaBO(int idreceita) {
		boolean resultado = false;
		ReceitaDAO receitaDAO = new ReceitaDAO();
		resultado = receitaDAO.excluirReceitaDAO(idreceita);
		return resultado;
	}
}
