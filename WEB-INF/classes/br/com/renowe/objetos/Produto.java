package br.com.renowe.objetos;

import java.io.Serializable;
public class Produto implements Serializable{

	private static final long serialVersionUID = 1654L;
	private int id;
	private String codigo;
	private String nome;
	private String descricao;
	
	private double valor;// valor em centavos
	private String imagem;
	private int quantidade;
	private double totalProduto;
	private int destaque;
	private long peso;
	private double custoFrete;
	
	private Categoria categoria;
	
	private int estoque;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int hashCode() {
		return new Integer(getId()).hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getImagem() {
		return imagem;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setTotalProduto(double totalProduto) {
		this.totalProduto = totalProduto;
	}

	public double getTotalProduto() {
		return totalProduto;
	}

	public void setDestaque(int destaque) {
		this.destaque = destaque;
	}

	public int getDestaque() {
		return destaque;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setCustoFrete(double custoFrete) {
		this.custoFrete = custoFrete;
	}

	public double getCustoFrete() {
		return custoFrete;
	}

	public void setPeso(long peso) {
		this.peso = peso;
	}

	public long getPeso() {
		return peso;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
