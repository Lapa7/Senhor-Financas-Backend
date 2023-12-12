package controller;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.bo.RelatorioBO;
import model.dto.RelatorioDTO;

@Path("/relatorio")
public class RelatorioRest {

	@GET
	@Path("/listar/{idusuario}/{ano}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RelatorioDTO> consultarRelatorioController(@PathParam("idusuario") int idusuario, @PathParam("ano") int ano){
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.consultarRelatorioBO(idusuario, ano);
	}
}
