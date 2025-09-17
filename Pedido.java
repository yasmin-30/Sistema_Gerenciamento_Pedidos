package gerenciamentoPedidos;

import java.util.ArrayList;

public class Pedido {
	private int id;
	private String nome;
	private ArrayList<Item> itens;
	
	public Pedido(int id, String nome, ArrayList<Item> itens) {
		this.id = id;
		this.nome = nome;
		this.itens = itens;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return nome;		
	}
	
	public ArrayList<Item> getItens() {
		return itens;
	}
	
	public void resumoPedido() {
		double valorTotal = 0;
		System.out.println("");
		System.out.println("---RESUMO DO PEDIDO---");
		System.out.println("Nome do cliente: " + this.nome + ".");
		System.out.println("Nº do pedido: " + this.id + ".");
		
		for(int i = 0; i < itens.size(); i++) {
			Item imprimirItem = itens.get(i);
			System.out.println("Item: " + imprimirItem.getNomeItem() + ".");
			valorTotal += imprimirItem.getPreco();
		}
		
		System.out.println("Total: " + valorTotal + ".");
	}
}
