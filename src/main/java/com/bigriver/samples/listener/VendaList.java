package com.bigriver.samples.listener;

import java.time.Instant;
import java.util.Date;

import javax.persistence.PrePersist;

import com.bigriver.samples.model.Venda;

public class VendaList {
	/**
	 * Classe que escutará os eventos dos objetos Venda
	 * @author Douglas
	 * @author Bruno
	 * @author Rafahel
	 *
	 */
		/**
		 * Antes de Salvar um Venda, garantir que a "timestamps" tenha a data / hora atual.
		 * @param Venda venda que está sendo salvo
		 */
		@PrePersist
		public void salvandoVenda(Venda venda){
			//Atualiza Timestamps para o momento atual
			venda.setTimestamps(Date.from(Instant.now()));		
		}
		
	}

