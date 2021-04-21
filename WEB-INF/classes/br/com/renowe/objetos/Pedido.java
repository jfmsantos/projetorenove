package br.com.renowe.objetos;

import java.util.List;

public class Pedido {

	private int id;
	private String date;
	private String code;
	private String reference;
	private int typeTransacao;
	private int statusPagseguro;
	private int paymentMethod;
	private String paymentMethodName;
	private int paymentCode;
	private String paymentCodeName;
	private double brutoCompra;
	private double descontos;
	private double taxasCobradas;
	private double liquidoCompra;
	private double valoresExtra;
	private int parcelas;
	private List<Produto> produtos;
	private int tipoFrete;
	private double custoFrete;
	private Cliente cliente;
	private double totalPedido;
	private String status;
	private int quantidade;
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
//		setTotalPedido(0);
//		for (Produto produto : produtos) {
//			setTotalPedido(getTotalPedido() + produto.getTotalProduto());
//		}
	}
	
	public List<Produto> getProdutos() {
		return this.produtos;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getTypeTransacao() {
		return typeTransacao;
	}

	public void setTypeTransacao(int typeTransacao) {
		this.typeTransacao = typeTransacao;
	}

	public int getStatusPagseguro() {
		return statusPagseguro;
	}

	public void setStatusPagseguro(int statusPagseguro) {
		this.statusPagseguro = statusPagseguro;
	}

	public int getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(int paymentCode) {
		this.paymentCode = paymentCode;
	}

	public double getBrutoCompra() {
		return brutoCompra;
	}

	public void setBrutoCompra(double brutoCompra) {
		this.brutoCompra = brutoCompra;
	}

	public double getDescontos() {
		return descontos;
	}

	public void setDescontos(double descontos) {
		this.descontos = descontos;
	}

	public double getTaxasCobradas() {
		return taxasCobradas;
	}

	public void setTaxasCobradas(double taxasCobradas) {
		this.taxasCobradas = taxasCobradas;
	}

	public double getLiquidoCompra() {
		return liquidoCompra;
	}

	public void setLiquidoCompra(double liquidoCompra) {
		this.liquidoCompra = liquidoCompra;
	}

	public double getValoresExtra() {
		return valoresExtra;
	}

	public void setValoresExtra(double valoresExtra) {
		this.valoresExtra = valoresExtra;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public int getTipoFrete() {
		return tipoFrete;
	}

	public void setTipoFrete(int tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	public double getCustoFrete() {
		return custoFrete;
	}

	public void setCustoFrete(double custoFrete) {
		this.custoFrete = custoFrete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMethodName() {
		return paymentMethodName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	public String getPaymentCodeName() {
		return paymentCodeName;
	}

	public void setPaymentCodeName(String paymentCodeName) {
		this.paymentCodeName = paymentCodeName;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidad) {
		this.quantidade = quantidad;
	}
}
