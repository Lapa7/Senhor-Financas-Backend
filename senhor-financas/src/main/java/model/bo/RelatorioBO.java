package model.bo;

import java.util.ArrayList;

import model.dao.RelatorioDAO;
import model.dto.RelatorioDTO;

public class RelatorioBO {

	public ArrayList<RelatorioDTO> consultarRelatorioBO(int idusuario, int ano){
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<RelatorioDTO> listaRelatorioDTO = relatorioDAO.consultarRelatorioDAO(idusuario, ano);
		return listaRelatorioDTO;
	}
}
