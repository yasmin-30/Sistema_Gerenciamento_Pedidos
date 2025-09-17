package gerenciamentoPedidos;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Sistema {

	public static void main(String[] args) {
		int idPedido = 0;
		boolean paradaPedido = false;
		LinkedList<Pedido> listaPedidos = new LinkedList<Pedido>();
		Scanner leitor = new Scanner(System.in);
		System.out.println("---BEM-VINDO AO RESTAURANTE!---");
		
		while(!paradaPedido) {
			System.out.println("");
			System.out.println("---O QUE DESEJA FAZER?---");
			System.out.println("1-Adicionar pedido. 2-Remover pedido. 3-Listar pedidos, 4-Sair.");
			int acao = leitor.nextInt();
			leitor.nextLine();
			
			switch(acao) {
				case 1:
					ArrayList<Item> itens = new ArrayList<Item>();
					boolean paradaItens = false;
					String nome;
					Pedido pedidoFinal = null;
					idPedido+=1;
					
					System.out.println("Escreva o nome do cliente:");
					nome = leitor.nextLine();
					
					while(!paradaItens) {
						Item novoItem = null;
						String nomeItem;
						double preco;
						System.out.println("Escreva o nome do item:");
						nomeItem = leitor.nextLine();
						System.out.println("Escreva o preço do item:");
						preco = leitor.nextDouble();
						leitor.nextLine();
						
						novoItem= new Item(nomeItem, preco);
						itens.add(novoItem);
						
						boolean verificacaoResp = false;
						while(!verificacaoResp) {
							System.out.println("Deseja adicionar mais itens ao pedido? Y/N");
							String resposta = leitor.nextLine();
							if(resposta.equalsIgnoreCase("N")) {
								paradaItens = true;
								verificacaoResp = true;
							} else if(!resposta.equalsIgnoreCase("Y")) {
								System.out.println("Responsta inválida, responda com Y ou N!");
								verificacaoResp = false;
							} else {
								verificacaoResp = true;
							}
						}
					}
					
					pedidoFinal = new Pedido(idPedido, nome, itens);
					pedidoFinal.resumoPedido();
					listaPedidos.add(pedidoFinal);
					break;
				
				case 2:	
					int verificar = 0;
					int tamPedidos = listaPedidos.size()-1;
					System.out.println("Informe o id do pedido: ");
					double idRemover = leitor.nextDouble();
					
		
			        for(Pedido remover : listaPedidos) {
			            if (remover.getId() == idRemover) {
			                listaPedidos.remove(remover);
			                System.out.println("Pedido removido!");
			                break;
			            } else {
			            	verificar+=1;
			            }
			        }
			        
			        if(verificar == tamPedidos) {
			        	System.out.println("ERRO! O pedido informado não está presente na lista!");
			        }
			        break;
			        
				case 3:
					System.out.println("---LISTAGEM DOS PEDIDOS---");
					for(int i=0; i < listaPedidos.size(); i++) {
						ArrayList<Item> listaItens = new ArrayList<Item>();
						Pedido imprimirPedido = listaPedidos.get(i);
						listaItens = imprimirPedido.getItens();
						
						System.out.println("");
						
						System.out.println("Cliente: " + imprimirPedido.getName() + ".");
						System.out.println("Nº do pedido: " + imprimirPedido.getId() + ".");
						for(int j=0; j < listaItens.size(); j++) {
							Item imprimirItem = listaItens.get(j);
							System.out.println("Item: " + imprimirItem.getNomeItem() + ".");
							System.out.println("Preço: " + imprimirItem.getPreco() + ".");
						}
					}
					break;
				case 4:
					paradaPedido = true;
					System.out.println("Pedidos realizados com sucesso!");
					System.out.println("---VOLTE SEMPRE---");
					break;
			}        
		}
		
		
		leitor.close();
	}

}
