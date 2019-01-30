package br.com.denisemend.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


import br.com.denisemend.dao.PlanetasDAO;
import br.com.denisemend.entidade.planetas;


@Path("/planetassw")
public class PlanetasSWService<Planetas> {
	
	private PlanetasDAO planetasDAO;
	
	@PostConstruct
	private void init() {
	    planetasDAO = new PlanetasDAO();
	}
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Planetas> listarPlanetas() {
		List<Planetas> lista = null;
		try{
			lista = (List<Planetas>) planetasDAO.listarPlanetas();
			} catch (Exception e) {
				e.printStackTrace();
				}
		        return lista;
		
	}
	
	
	@GET
	@Path("/get/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public planetas buscarPorId(@PathParam("id") int idPlanetas) {
		planetas planetas = null;
		try{
			planetas = planetasDAO.buscarPlanetasPorId(idPlanetas);
			} catch (Exception e) {
				e.printStackTrace();
				}
		        return planetas;
	}
	
	@GET
	@Path("/get/{Nome}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Planetas buscarPorNome(@PathParam("string") String NomePlanetas) {
		Planetas planetas = null;
		try{
			planetas =  planetasDAO.buscarPlanetasPorNome();
			} catch (Exception e) {
				e.printStackTrace();
				}
		        return planetas;
	}
	
	
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addPlanetas(Planetas planetas) {
		String msg = "";
		
		System.out.println(planetas.getNome);
		 
		try{
			planetasDAO.addPlanetas(planetas);
			
			msg = "Planeta add com sucesso!";
			} catch (Exception e) { 
				msg = "Erro ao add o planeta!";
				e.printStackTrace();
			}
		
		return msg;
		
	}
	
	
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerPlanetas(@PathParam("id") int idPlanetas) {
		String msg = "";
		try{
			planetasDAO = removerPlanetas(idPlanetas);
			
			msg = "Planeta removido com sucesso!";
			} catch (Exception e) {
				msg = "Erro ao remover o planeta";
				e.printStackTrace();
				}
		        return msg;
	}
		
	}

	










