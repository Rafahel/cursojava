package com.bigriver.samples.model;

import com.dooapp.fxform.annotation.NonVisual;

public class Jogo {
	
	@NonVisual
	private int id;
	private String nome, genero, plataforma;
	private int jogadores;
	private double preco;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	public int getJogadores() {
		return jogadores;
	}
	
	public void setJogadores(int jogadores) {
		this.jogadores = jogadores;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
