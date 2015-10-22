package com.bigriver.samples.service;

import java.util.Collection;

import com.bigriver.samples.dao.VendaDAO;
import com.bigriver.samples.model.Pessoa;
import com.bigriver.samples.model.Venda;

public class Vendas implements ServicoVenda<Venda>{
	//Um atributo primário para busca de Jogos
		private VendaDAO dao;

		public Vendas() {
			this.dao = new VendaDAO();
		}
		
		@Override
		public Collection<Venda> todosNaoVendidos() {
			//Consultar todas os Jogos do banco de dados.
			//Alterar para uma busca de produtos/itens não vendidos.
			return dao.todos();
		}

		@Override
		public void vender(Venda produto, Pessoa cliente) {
			//Implementa a lógica para a venda de um jogo
			System.out.format("Vendeu o Jogo %s, para %s", produto, cliente);
		}

}
