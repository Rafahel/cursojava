package com.bigriver.samples.dao;

import java.util.Collection;

import javax.persistence.EntityManager;

import com.bigriver.samples.BancoDeDados;
import com.bigriver.samples.model.Jogo;

public class JogoVendidoDAO extends JogoDAO {
	/**
	 * Coletar todas as ocorrências de jogos VENDIDOS do Banco de Dados
	 * @return Uma coleção com todas as ocorrências de jogo
	 */
	@Override
	public Collection<Jogo> todos() {
		EntityManager gerenteEntidades = BancoDeDados.abreEntityManager();
		gerenteEntidades.getTransaction().begin();
		//Cria uma QUERY que buscará TODAS as jogos no BD
		@SuppressWarnings("unchecked")
		Collection<Jogo> todos = gerenteEntidades.createQuery("from Jogo")
				.getResultList();
		
		for(Jogo jogo : todos) {
			if(jogo.isDisponivel()) {
				todos.remove(jogo);
			}
		}
		
		//Garante a conclusão da operação
		gerenteEntidades.getTransaction().commit();
		gerenteEntidades.close();
		
		return todos;
	}
}
