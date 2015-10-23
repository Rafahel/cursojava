package com.bigriver.samples;

import com.bigriver.samples.dao.JogoDAO;
import com.bigriver.samples.dao.JogoNaoVendidoDAO;
import com.bigriver.samples.dao.JogoVendidoDAO;
import com.bigriver.samples.dao.PessoaDAO;
import com.bigriver.samples.dao.VendaDAO;
import com.bigriver.samples.model.Endereco;
import com.bigriver.samples.model.Jogo;
import com.bigriver.samples.model.Pessoa;
import com.bigriver.samples.model.Venda;
import com.bigriver.samples.service.VendaJogo;
import com.bigriver.samples.view.TelaCadastro;
import com.bigriver.samples.view.TelaConsulta;
import com.bigriver.samples.view.TelaDashboard;
import com.bigriver.samples.view.TelaVendas;
import com.guigarage.flatterfx.FlatterFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashBoard extends Application {
	//Titulo da Janela
	static final String TITULO = "Venda de Produtos";
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Carrega um objeto Pessoa e Endereço
		Pessoa pessoa = new Pessoa();
		Jogo jogo = new Jogo();
		Endereco endereco = new Endereco();
		pessoa.setEndereco(endereco);
		
		//Carrega um DAO de Pessoas
		PessoaDAO pessoa_dao_cadastro = new PessoaDAO();
		//Cria uma tela de cadastro de Pessoas
		TelaCadastro<Pessoa> pessoa_cadastro = new TelaCadastro<>("Cadastro Pessoa", pessoa, pessoa_dao_cadastro, endereco);
		
		//Carrega um DAO de Jogos
		JogoDAO jogo_dao_cadastro = new JogoDAO();
		//Cria uma tela de cadastro de Jogos
		TelaCadastro<Jogo> jogo_cadastro = new TelaCadastro<>("Cadastro Jogo", jogo, jogo_dao_cadastro);		
	
		//Cria um DAO para as Pessoas
		PessoaDAO pessoa_dao_consulta = new PessoaDAO();
		//Cria uma Tela de Consulta de Pessoas
		TelaConsulta<Pessoa> pessoa_consulta = new TelaConsulta<>("Consulta Pessoas", pessoa_dao_consulta);
		
		//Cria um DAO para os Jogos Não Vendidos
		JogoDAO jogoNV_dao_consulta = new JogoNaoVendidoDAO();
		//Cria uma Tela de Consulta de Pessoas
		TelaConsulta<Jogo> jogoNV_consulta = new TelaConsulta<>("Consulta Jogos Não Vendidos", jogoNV_dao_consulta);
		
		//Cria um DAO para os Jogos Não Vendidos
		JogoDAO jogoVendido_dao_consulta = new JogoVendidoDAO();
		//Cria uma Tela de Consulta de Pessoas
		TelaConsulta<Jogo> jogoVendido_consulta = new TelaConsulta<>("Consulta Jogos Vendidos", jogoVendido_dao_consulta);
		
		//Cria uma Tela para Venda de Jogos
		VendaJogo venda_jogos = new VendaJogo();
		
		//Cria uma Tela de Vendas
		TelaVendas<Jogo> telaVendas = new TelaVendas<>("Venda Jogos", venda_jogos);
		
		//Cria um DAO para as Vendas
		VendaDAO venda_dao_consulta = new VendaDAO();
		//Cria uma Tela de Consulta de Pessoas
		TelaConsulta<Venda> venda_consulta = new TelaConsulta<>("Consulta Vendas", venda_dao_consulta);
		
		//Cria uma tela de DashBoard com as telas de Consulta e Cadastro de Pessoas
		TelaDashboard telaDashboard = new TelaDashboard(pessoa_consulta, pessoa_cadastro, jogoNV_consulta, jogoVendido_consulta, jogo_cadastro, telaVendas, venda_consulta);
		
		//Cria uma Scene (JavaFX) com a tela de consulta
		Scene scene = new Scene(telaDashboard);
				
		//Cria uma Janela de Consulta
		primaryStage.setScene(scene);
		
		//Titulo da Aplicação
		primaryStage.setTitle(TITULO);
				
		//Abre a Janela
		primaryStage.show();
		//Quando fechar a aplicação, garante que
		primaryStage.setOnCloseRequest(evt -> {
			//Fecha todas as conexões com a base de dados
			BancoDeDados.closeFactory();
		});
		
		
		//Tema Especial para a Dashboard
		FlatterFX.style();
	}

}
