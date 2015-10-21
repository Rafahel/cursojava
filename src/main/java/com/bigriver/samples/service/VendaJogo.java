package com.bigriver.samples.service;

import java.util.Collection;

import com.bigriver.samples.dao.JogoDAO;
import com.bigriver.samples.model.Jogo;
import com.bigriver.samples.model.Pessoa;

/**
 * Classe para a criação de vendas de jogo
 * @author Rodney
 * @author Douglas
 */
public class VendaJogo implements ServicoVenda<Jogo> {
	
	//Um atributo primário para busca de Jogos
	private JogoDAO dao;

	public VendaJogo() {
		this.dao = new JogoDAO();
	}
	
	@Override
	public Collection<Jogo> todosNaoVendidos() {
		//Consultar todas os Jogos do banco de dados.
		//Alterar para uma busca de produtos/itens não vendidos.
		return dao.todos();
	}

	@Override
	public void vender(Jogo produto, Pessoa cliente) {
		//Implementa a lógica para a venda de um jogo
		System.out.format("Vendeu a Jogo %s, para %s", produto, cliente);
	}

}