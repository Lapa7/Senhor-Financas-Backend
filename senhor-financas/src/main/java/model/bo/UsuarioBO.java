package model.bo;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	public UsuarioVO cadastrarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO= new UsuarioDAO();
		if(usuarioDAO.verificarUsuarioCadastradoDAO(usuarioVO)) {
			System.out.println("Usuario ja cadastrado");
		} else {
			usuarioVO = usuarioDAO.cadastrarUsuarioDAO(usuarioVO);
		}
		return usuarioVO;
	}
	
	public UsuarioVO verificarLoginBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuario = usuarioDAO.verificarLoginDAO(usuarioVO);
		return usuario;
	}
}
