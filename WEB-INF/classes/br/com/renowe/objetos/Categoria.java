package br.com.renowe.objetos;

import java.io.Serializable;
import java.util.List;

public class Categoria implements Serializable{


	private static final long serialVersionUID = 1879213L;

	private int id;
	private String nome;
	private List<Produto> produtos;
	
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}