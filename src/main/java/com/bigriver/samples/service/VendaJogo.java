package com.bigriver.samples.service;

import java.util.Collection;

import com.bigriver.samples.dao.JogoDAO;
import com.bigriver.samples.dao.VendaDAO;
import com.bigriver.samples.model.Jogo;
import com.bigriver.samples.model.Pessoa;
import com.bigriver.samples.model.Venda;

/**
 * Classe para a criação de vendas de jogo
 * @author Rodney
 * @author Douglas
 */
public class VendaJogo implements ServicoVenda<Jogo> {
	
	//Um atributo primário para busca de Jogos
	private JogoDAO dao;
	private VendaDAO vendaDao;

	public VendaJogo() {
		this.dao = new JogoDAO();
		this.vendaDao = new VendaDAO();
	}
	
	@Override
	public Collection<Jogo> todosNaoVendidos() {
		//Consultar todas os Jogos do banco de dados.
		//Alterar para uma busca de produtos/itens não vendidos.
		Collection<Jogo> todos = dao.todos();
		for(Jogo jogo : todos) {
			if(!jogo.isDisponivel()) {
				todos.remove(jogo);
			}
		}
		return todos;
	}

	@Override
	public void vender(Jogo produto, Pessoa cliente) {
		//Implementa a lógica para a venda de um jogo
		produto.setDisponivel(false);
		Venda venda = new Venda();
		venda.setJogo(produto);
		venda.setComprador(cliente);
		dao.salvar(produto);
		vendaDao.salvar(venda);
		System.out.format("Venda criada");
	}
}