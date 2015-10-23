package com.bigriver.samples.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.bigriver.samples.listener.VendaList;
import com.dooapp.fxform.annotation.NonVisual;
@Entity
@EntityListeners(VendaList.class)
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
	
	public String toString() {
		String str = "Jogo ";
		str += jogo.toString();
		str += " vendido para ";
		str += comprador.toString();
		str += " em ";
		str += timestamps.toString() + ".";
		
		return str;
	}
	
}
