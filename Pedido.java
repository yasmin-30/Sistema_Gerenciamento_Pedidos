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
		
		System.out.println("\n========================================");
		System.out.println("               REST AURANTE               ");
		System.out.println("========================================");
		System.out.println("");
		System.out.println("Cliente: " + this.nome);
		System.out.println("Pedido N°: " + this.id);
		System.out.println("----------------------------------------");
		System.out.println("Itens:");

		
		for(int i = 0; i < itens.size(); i++) {
			Item imprimirItem = itens.get(i);
			System.out.println("- " + imprimirItem.getNomeItem() + " R$ " + imprimirItem.getPreco());
			valorTotal += imprimirItem.getPreco();
		}
		
		System.out.println("----------------------------------------");
		System.out.println("Total: R$ " + valorTotal);
		System.out.println("========================================");
		System.out.println("      Obrigado pela preferência! :)     ");
		System.out.println("========================================\n");
	}
}
