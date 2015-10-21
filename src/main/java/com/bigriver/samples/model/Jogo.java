package com.bigriver.samples.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bigriver.samples.listener.JogoListener;
import com.dooapp.fxform.annotation.NonVisual;

/**
 * Classe da tabela jogo do banco de dados
 * @author bluzcom
 * @author Douglas
 */
@Entity
@EntityListeners(JogoListener.class)
public class Jogo {
	//Não exibir o id do jogo
	@NonVisual
	private int id;
	
	//Não exibir em formulários
	@NonVisual
	private Date timestamps;
		
	private String nome, genero, plataforma;
	private int jogadores;
	private double preco;
	
	@Id
	@GeneratedValue
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
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTimestamps() {
		return timestamps;
	}
	
	public void setTimestamps(Date timestamps) {
		this.timestamps = timestamps;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
