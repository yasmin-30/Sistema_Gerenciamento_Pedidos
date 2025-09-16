package gerenciamentoPedidos;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class Sistema {
//FAZER VERIFICAÇÃO PARA NUMEROS NEGATIVOS OU QUE MUITO GRANDES NÃO PRESENTES
	public static void main(String[] args) {
		int idPedido = 0;
		boolean paradaPedido = false;
		LinkedList<Pedido> listaPedidos = new LinkedList<Pedido>();
		Scanner leitor = new Scanner(System.in);
		
		while(!paradaPedido) {
			System.out.println("Seja bem vindo ao restaurante------! Digite o número da ação que deseja realizar: ");
			System.out.println("1-Adicionar pedido. 2-Remover pedido. 3-Listar pedidos., 4-Sair.");
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
					
					// FAZER WHILE DOS ITENS DO PEDIDO
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
						
						System.out.println("Deseja adicionar mais itens ao pedido? Y/N");
						String resposta = leitor.nextLine();
						if(resposta.equalsIgnoreCase("N")) {
							paradaItens = true;
						}
					}
					
					pedidoFinal = new Pedido(idPedido, nome, itens);			
					listaPedidos.add(pedidoFinal);
					break;
				
				case 2:
					int removido = 0;
					
					System.out.println("Informe o id do pedido: ");
					double idRemover = leitor.nextDouble();
		
			        Iterator<Pedido> iterator = listaPedidos.iterator();
			        while (iterator.hasNext()) {
			            Pedido pedidoAtual = iterator.next();
			            if (pedidoAtual.getId() == idRemover) {
			                iterator.remove();
			                System.out.println("Pedido removido!");
			            } else {
			            	removido+=1;
			            }
			        }
			        
			        if(removido == listaPedidos.size()-1) {
			        	System.out.println("ERRO! O pedido informado não está presente na lista!");
			        }
			        break;
			        
				case 3:
					for(int i=0; i < listaPedidos.size(); i++) {
						System.out.println(listaPedidos.get(i));
					}
					break;
				case 4:
					paradaPedido = true;
					System.out.println("Pedidos realizados com sucesso, volte sempre!");
					break;
			}        
		}
		
		
		leitor.close();
	}

}
