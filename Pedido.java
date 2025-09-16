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
}
