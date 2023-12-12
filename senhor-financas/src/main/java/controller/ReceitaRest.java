package controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.bo.ReceitaBO;
import model.vo.ReceitaVO;

@Path("/receita")
public class ReceitaRest {
	
	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReceitaVO cadastrarReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO();
		return receitaBO.cadastrarReceitaBO(receitaVO);
	}
	
	@GET
	@Path("/listar/{idusuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReceitaVO> consultarTodasReceitasController(@PathParam("idusuario") int idusuario){
		ReceitaBO receitaBO = new ReceitaBO();
		return receitaBO.consultarTodasReceitasBO(idusuario);
	}
	
	@GET
	@Path("/pesquisar/{idreceita}")
	@Produces(MediaType.APPLICATION_JSON)
	public ReceitaVO consultarReceitaController(@PathParam("idreceita") int idreceita){
		ReceitaBO receitaBO = new ReceitaBO();
		return receitaBO.consultarReceitaBO(idreceita);
	}
	
	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean atualizarReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO();
		return receitaBO.atualizarReceitaBO(receitaVO);
	}
	
	@DELETE
	@Path("/excluir/{idreceita}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean excluirReceitaController(@PathParam("idreceita") int idreceita) {
		ReceitaBO receitaBO = new ReceitaBO();
		return receitaBO.excluirReceitaBO(idreceita);
	}
}
