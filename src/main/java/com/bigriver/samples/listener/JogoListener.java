package com.bigriver.samples.listener;

import java.time.Instant;
import java.util.Date;

import javax.persistence.PrePersist;
import com.bigriver.samples.model.Jogo;

/**
 * Classe que escutará os eventos dos objetos Jogo
 * @author Douglas
 * @author Bruno
 *
 */
public class JogoListener {
	
	/**
	 * Antes de Salvar um Jogo, garantir que a "timestamps" tenha a data / hora atual.
	 * @param jogo Jogo que está sendo salvo
	 */
	@PrePersist
	public void salvandoJogo(Jogo jogo){
		//Atualiza Timestamps para o momento atual
		jogo.setTimestamps(Date.from(Instant.now()));		
	}
	
}
