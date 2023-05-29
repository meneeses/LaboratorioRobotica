import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        System.out.println("Seja bem-vindo ao Laboratorio de Robotica");
        
        List<Peca> estoquePecas = new ArrayList<>();
          List<Robo> robosConcluidos = new ArrayList<>();
          Scanner scanner = new Scanner(System.in); 

            //Cadastrar  no estoque
            System.out.println("=== Cadastro de Pecas ===");
            while(true) {
              System.out.print("Identificacao da peca (ou 'sair' para encerrar): ");
              String item = scanner.nextLine();
              if (item.equalsIgnoreCase("sair")){
                break;
              }
      
              System.out.print("Quantidade: ");
              int quantidade = Integer.parseInt(scanner.nextLine());
              
              System.out.print("Valor Unitario: ");
              double valorUnitario = Double.parseDouble(scanner.nextLine());
      
              Peca peca = new Peca (item, quantidade, valorUnitario);
              estoquePecas.add(peca);
            }
      
            //Montar Robôs
            System.out.println("\n=== Montagem de Robos ===");
      
            while(true) {
              Robo robo = new Robo();
              System.out.println("\nRobo em construcao...");
      
              while(true){
                System.out.print("Identificacao da peca (ou 'concluir' para finalizar o robo): ");
                String item = scanner.nextLine();
                if (item.equalsIgnoreCase("concluir")) {
                  break;
                }
      
                Peca pecaUtilizada = null;
                for (Peca peca : estoquePecas) {
                  if (peca.getItem().equals(item)) {
                      pecaUtilizada = peca;
                      break;
                  } else {
                  }
                }
      
                if (pecaUtilizada == null) {
                  System.out.println("Peca nao encontrada no estoque!");
                } else if (pecaUtilizada.getQuantidade() == 0) {
                  System.out.println("Peca esgostada no estoque");
                } else {
                  robo.adicionarPeca(pecaUtilizada);
                  pecaUtilizada.decrementarQuantidade(1);
                  System.out.println("Peca adicionada ao robo");
                }
              }
      
              robosConcluidos.add(robo);
      
              System.out.println("\nRobo concluido!");
              robo.mostrarPecasUtilizadas();
              System.out.println("Custo total do robo: R$" + robo.getCustoTotal());
      
              System.out.println("\nDeseja montar outro robo? (s/n): ");
              String opcao = scanner.nextLine();
              if (!opcao.equalsIgnoreCase("s")) {
                break;
              }
            }

           //Listar estoque de peças
           System.out.println("\n=== Estoque de Pecas ===");
          
           for(Peca peca : estoquePecas) {
               System.out.println("Identificacao: " + peca.getItem());
               System.out.println("Quantidade: " + peca.getQuantidade());
               System.out.println("Valor unitario: R$" + peca.getValorUnitario());
               System.out.println();
           }
       
            // Listar robôs concluídos
            System.out.println("\n=== Robos Concluidos ===");
       
            for (Robo robo : robosConcluidos) {
                robo.mostrarPecasUtilizadas();
                System.out.println("Custo total do robo: R$" + robo.getCustoTotal());
                System.out.println();
            }

        }
    }

