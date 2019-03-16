package com.algaworks.beanstestes;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MeuBean {

	private String nome;
	private int quantidade;

	public void transformar() {
		this.nome = this.nome.toUpperCase();
		this.quantidade = this.nome.length();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
