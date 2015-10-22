package com.bigriver.samples.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dooapp.fxform.annotation.NonVisual;

public class Venda {
/**
 * Classe da tabela vendas do sistema
 * @author Bruno
 * 
 */
	private int codigo;
	@NonVisual 
	//Não exibir em formulários
	private Date timestamps;
	private Pessoa comprador;
	private Jogo jogo;
	
	@OneToOne
	public Pessoa getComprador() {
		return comprador;
	}

	public void setComprador(Pessoa comprador) {
		this.comprador = comprador;
	}
	@OneToOne
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

 @Id
 @GeneratedValue
public int getCodigo() {
		return codigo;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}

@Temporal(TemporalType.TIMESTAMP)
public Date getTimestamps() {
	return timestamps;
}

public void setTimestamps(Date timestamps) {
	this.timestamps = timestamps;
}
	
}
