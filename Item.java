package gerenciamentoPedidos;

public class Item {
	private String nomePedido;
	private double preco;
	
	public Item(String nome, double preco) {
		this.nomePedido = nome;
		this.preco = preco;
	}
	
	public String getNomePedido() {
		return nomePedido;
	}
	
	public double getPreco() {
		return preco;
	}
}
