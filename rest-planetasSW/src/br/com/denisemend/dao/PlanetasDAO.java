package br.com.denisemend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.denisemend.config.BDConfig;
import br.com.denisemend.entidade.planetas;

public class PlanetasDAO {
	
	public List<planetas> listarPlanetas() throws Exception {
		List<planetas> lista = new ArrayList<> ();
		
		Connection conexao = BDConfig.getConnection();
		
		String sql = "SELECT * FROM TB_PLANETAS";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
		    planetas planetas = new planetas();
			planetas.setId(rs.getInt("ID_PLANETAS"));
			planetas.setNome(rs.getString("NOME"));
			planetas.setClima(rs.getString("CLIMA"));
			planetas.setTerreno(rs.getString("TERRENO"));
			planetas.setFilme(rs.getString("FILME"));
			
			lista.add((planetas)(planetas));
		}
		return lista;
		
	}
	
	public planetas buscarPlanetasPorId(int idPlanetas) throws Exception {
		planetas planetas = null;
		
		Connection conexao = BDConfig.getConnection();
		
		String sql = "SELECT * FROM TB_PLANETAS WHERE ID_PLANETAS = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idPlanetas);
		ResultSet rs = statement.executeQuery();
		
		if (rs.next()) {
			planetas planetas1 = new planetas();
			planetas1.setId(rs.getInt("ID_PLANETAS"));
			planetas1.setNome(rs.getString("NOME"));
			planetas1.setClima(rs.getString("CLIMA"));
			planetas1.setTerreno(rs.getString("TERRENO"));
			planetas1.setFilme(rs.getString("FILME"));
			
		}
		
		return planetas;
		
	}
	
	public planetas buscarPlanetaPorNome(String NomePlanetas) throws Exception {
		planetas planetas = null;
		
		Connection conexao = BDConfig.getConnection();
		
		String sql = "SELECT * FROM TB_PLANETA WHERE NOME_PLANETA = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, NomePlanetas);
		ResultSet rs = statement.executeQuery();
		
		if (rs.next()) {
			planetas planetas1 = new planetas();
			planetas1.setId(rs.getInt("ID_PLANETAS"));
			planetas1.setNome(rs.getString("NOME"));
			planetas1.setClima(rs.getString("CLIMA"));
			planetas1.setTerreno(rs.getString("TERRENO"));
			planetas1.setFilme(rs.getString("FILME"));
			
		}
		
		return planetas;
		
	}
	
	public void addPlanetas (Planetas planetas) throws Exception {
		Connection conexao = BDConfig.getConnection();
		
		String sql = "INSERT INTO TB_PLANETAS(NOME,CLIMA,TERRENO,FILME) VALUES(?, ?,? )";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, planetas.getNome());
		statement.setString(2, planetas.getClima());
		statement.setString(3, planetas.getTerreno());
		statement.setString(4, planetas.getFilme());
		statement.execute ();
		
	}
	
	public void removerPlanetas (int planetas) throws Exception {
        Connection conexao = BDConfig.getConnection();
		
		String sql = "DELETE FROM TB_PLANETAS WHERE ID_PLANETAS";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, planetas);
		statement.execute();
		
	}
	
	
}































