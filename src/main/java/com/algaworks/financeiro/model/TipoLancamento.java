package com.algaworks.financeiro.model;

public enum TipoLancamento {

	RECEITA("Receita"), DESPESA("Despesas");

	private String descricao;

	private TipoLancamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
