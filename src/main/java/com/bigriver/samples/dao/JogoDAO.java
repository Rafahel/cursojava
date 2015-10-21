package com.bigriver.samples.dao;

import java.util.Collection;

import javax.persistence.EntityManager;

import com.bigriver.samples.BancoDeDados;
import com.bigriver.samples.model.Jogo;

public class JogoDAO implements DAO<Jogo> {
	
	/**
	 * Salvar uma ocorrência de Jogo no Banco de Dados
	 * @param objeto A ocorrência que deverá ser salva
	 * @return A jogo que foi salva
	 */
	@Override
	public Jogo salvar(Jogo objeto) {
		//Abre um gerente de entidades
		EntityManager gerenteEntidades = BancoDeDados.abreEntityManager();
		//Abre uma transação com o BD
		gerenteEntidades.getTransaction().begin();
		//Guarda o Objeto no BD
		gerenteEntidades.persist(objeto);
		//Conclui a transação com o BD, garantindo a execução da operação
		gerenteEntidades.getTransaction().commit();
		//Fecha o Gerente de Entidades, concluindo o ciclo de vida de operações
		gerenteEntidades.close();
		
		return objeto;
	}
	
	/**
	 * Buscar uma ocorrência de jogo no Banco de Dados
	 * @param id O identificador único da jogo que deverá ser buscada
	 * @return A jogo encontrada
	 */
	@Override
	public Jogo buscar(int id) {
		//Abre um gerente de entidades
		EntityManager gerenteEntidades = BancoDeDados.abreEntityManager();
		//Abre uma transação com o BD
		gerenteEntidades.getTransaction().begin();		
		//Busca uma jogo no BD pelo ID - X
		Jogo busca = gerenteEntidades.find(Jogo.class, id);
		//Conclui a transação com o BD, garantindo a execução da operação
		gerenteEntidades.getTransaction().commit();

		gerenteEntidades.close();
		
		return busca;
	}

	/**
	 * Coletar todas as ocorrências de jogos do Banco de Dados
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
		//Garante a conclusão da operação
		gerenteEntidades.getTransaction().commit();
		gerenteEntidades.close();
		
		return todos;
	}
	
}
