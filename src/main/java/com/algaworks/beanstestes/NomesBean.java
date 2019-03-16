package com.algaworks.beanstestes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean(name = "nomesBean")
@ViewScoped
public class NomesBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String nome;
	private List<String> nomes = new ArrayList<String>();

	private HtmlInputText inputNome;
	private HtmlCommandButton botaoAdcionar;

	public void adicionar() {
		this.nomes.add(nome);
		
		/** DESATIVA CAMPO QUANDO MAIS QUE 3 NOMES FOREM ADICIONADOS **/
		if(this.nomes.size() > 3){
			this.inputNome.setDisabled(true);
			this.botaoAdcionar.setDisabled(true);
			this.botaoAdcionar.setValue("Muitos nomes adicionados..");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getNomes() {
		return nomes;
	}

	public HtmlInputText getInputNome() {
		return inputNome;
	}

	public void setInputNome(HtmlInputText inputNome) {
		this.inputNome = inputNome;
	}

	public HtmlCommandButton getBotaoAdcionar() {
		return botaoAdcionar;
	}

	public void setBotaoAdcionar(HtmlCommandButton botaoAdcionar) {
		this.botaoAdcionar = botaoAdcionar;
	}

}
