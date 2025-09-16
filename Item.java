package gerenciamentoPedidos;

public class Item {
	private String nomeItem;
	private double preco;
	
	public Item(String nome, double preco) {
		this.nomeItem = nome;
		this.preco = preco;
	}
	
	public String getNomeItem() {
		return nomeItem;
	}
	
	public double getPreco() {
		return preco;
	}
}
