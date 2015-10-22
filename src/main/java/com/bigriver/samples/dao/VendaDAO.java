package com.bigriver.samples.dao;

import java.util.Collection;

import javax.persistence.EntityManager;

import com.bigriver.samples.BancoDeDados;
import com.bigriver.samples.model.Jogo;
import com.bigriver.samples.model.Pessoa;
import com.bigriver.samples.model.Venda;

public class VendaDAO implements DAO<Venda>{
	/**
	 * Ocorrencias da venda do banco de dados
	 * @author bruno
	 * 
	 */
	@Override
	public Venda salvar(Venda objeto) {
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
	@Override
	public Venda buscar(int id) {
		//Abre um gerente de entidades
		EntityManager gerenteEntidades = BancoDeDados.abreEntityManager();
		//Abre uma transação com o BD
		gerenteEntidades.getTransaction().begin();		
		//Busca uma jogo no BD pelo ID - X
		Venda busca = gerenteEntidades.find(Venda.class, id);
		//Conclui a transação com o BD, garantindo a execução da operação
		gerenteEntidades.getTransaction().commit();

		gerenteEntidades.close();
		
		return busca;
	}

	/**
	 * Coletar todas as ocorrências de vendas do Banco de Dados
	 * @return Uma coleção com todas as ocorrências de vendas 
	 *
	 */
	@Override
	public Collection<Venda> todos() {
		EntityManager gerenteEntidades = BancoDeDados.abreEntityManager();
		gerenteEntidades.getTransaction().begin();
		//Cria uma QUERY que buscará TODAS as jogos no BD
		@SuppressWarnings("unchecked")
		Collection<Venda> todos = gerenteEntidades.createQuery("from Venda")
				.getResultList();
		//Garante a conclusão da operação
		gerenteEntidades.getTransaction().commit();
		gerenteEntidades.close();
		
		return todos;
	}
	


}


