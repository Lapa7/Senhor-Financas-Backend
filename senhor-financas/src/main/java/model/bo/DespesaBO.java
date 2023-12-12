package model.bo;

import java.util.ArrayList;

import model.dao.DespesaDAO;
import model.vo.DespesaVO;

public class DespesaBO {

	public DespesaVO cadastrarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		despesaDAO.cadastrarDespesaDAO(despesaVO);
		return despesaVO;
	}
	
	public ArrayList<DespesaVO> consultarTodasDespesasBO(int idusuario){
		DespesaDAO despesaDAO = new DespesaDAO();
		ArrayList<DespesaVO> listaDespesasVO = despesaDAO.consultarTodasDespesasDAO(idusuario);
		return listaDespesasVO;
	}
	
	public DespesaVO consultarDespesaBO(int iddespesa) {
		DespesaDAO despesaDAO = new DespesaDAO();
		DespesaVO despesa = despesaDAO.consultarDespesaDAO(iddespesa);
		return despesa;
	}
	
	public boolean atualizarDespesaBO(DespesaVO despesaVO) {
		boolean resultado = false;
		DespesaDAO despesaDAO = new DespesaDAO();
		resultado = despesaDAO.atualizarDespesaDAO(despesaVO);
		return resultado;
	}
	
	public boolean excluirDespesaBO(int iddespesa) {
		boolean resultado = false;
		DespesaDAO despesaDAO = new DespesaDAO();
		resultado = despesaDAO.excluirDespesaDAO(iddespesa);
		return resultado;
	}
}
