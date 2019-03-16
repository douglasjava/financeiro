package com.algaworks.financeiro.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.algaworks.financeiro.exceptions.NegocioException;
import com.algaworks.financeiro.model.Lancamento;
import com.algaworks.financeiro.repository.Lancamentos;
import com.algaworks.financeiro.util.Transactional;

public class CadastroLancamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Lancamentos lancamentos;

	public CadastroLancamento(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	public CadastroLancamento() {
		
	}

	@Transactional
	public void salvar(Lancamento lancamento) throws NegocioException {
		if (lancamento.getDataPagamento() != null && lancamento.getDataPagamento().after(new Date())) {
			throw new NegocioException("Data de pagamento não pode ser uma data futura");
		}
		this.lancamentos.guardar(lancamento);
	}
	
	@Transactional
	public void excluir(Lancamento lancamento) throws NegocioException {
		lancamento = this.lancamentos.porId(lancamento.getId());
/*		if(lancamento.getDataPagamento() != null){
			throw new NegocioException("Não é possivel excluir um lançamento pago");
		}*/
		this.lancamentos.remover(lancamento);
	}

}