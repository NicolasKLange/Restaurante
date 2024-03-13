package provanr1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class ProvaNr1 {
    public static void main(String[] args) {
        
        //Criacao de vetor
        int[] arrayMesas = new int[20];
             
        //Criacao de variaveis
        char escolhaMenu;
        int reservaMesas;
        char fimprograma = 'N';
        
        Scanner sc = new Scanner(System.in);
        
        //Verificar se o usuario deseja constinuar no programa
        while(fimprograma == 'N'){
        
        //criacao do menu
        System.out.println("\n******* MENU *******");
        System.out.println("V = Verificar mesas");
        System.out.println("R = Fazer reserva");
        System.out.println("L = Liberar mesa");
        System.out.print("Informe a letra correspondente: ");
        escolhaMenu = sc.next().toUpperCase().charAt(0);
        
        //Limpar a entrada de dados
        limparSaida();  
        
        //Laco para verificar se usuario digitou a letra corresponde
        while (escolhaMenu != 'V' && escolhaMenu != 'R' && escolhaMenu != 'L'){
            System.out.println("Opcao invalida! (V / R / L)");
            escolhaMenu = sc.next().toUpperCase().charAt(0);
        }
        
        //Limpar a entrada de dados  
        limparSaida();
        
        //Mostrar as mesas ocupadas e vagas
        if (escolhaMenu == 'V') {
            System.out.println("****** Mesas ******");
            System.out.println("0 - Vagas | 1 - Ocupadas\n");
            for (int mesa = 0; mesa < 20; mesa++) {
                System.out.println("M" + mesa  + " - " + arrayMesas[mesa]);
            }
        }
        
            //Fazer reserva
            else if(escolhaMenu == 'R'){
                System.out.println("***** Reserva *****");
                System.out.println("Mesa que deseja reservar: ");
                reservaMesas = sc.nextInt();
                        if(arrayMesas[reservaMesas] == 0){
                            System.out.println("Mesa " + reservaMesas  + " reservada com sucesso!!");
                            arrayMesas[reservaMesas] = 1;
                        }
                            else{
                                System.out.println("Mesa ja esta reservada!!");
                            }
            }

                //Liberar mesa
                else if(escolhaMenu == 'L'){
                    System.out.println("***** Liberar *****");
                    System.out.println("Mesa que deseja liberar: ");
                    reservaMesas = sc.nextInt();
                        if(arrayMesas[reservaMesas] == 1){
                            System.out.println("Mesa " + reservaMesas  + " liberada com sucesso!!");
                            arrayMesas[reservaMesas] = 0;
                        }
                            else{
                                System.out.println("Mesa ja esta liberada!!");
                            }
                }
        
            //Verificar se usuário prossegue no programa
            System.out.print("Finaliza programa? (S / N): ");
            fimprograma = sc.next().toUpperCase().charAt(0);
            
            //Se usuário colocar um valor diferete de S ou N repete a pergunta
            while (fimprograma != 'S' && fimprograma != 'N') {
                System.out.println("Opcao invalida! (S / N)");
                fimprograma = sc.next().toUpperCase().charAt(0);
            }
        }
    }
    
        //Função que limpa a Saída/Output do Netbeans
        public final static void limparSaida() {
            try {
                Robot robot = new Robot();
                robot.setAutoDelay(10);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_L);
            } catch (AWTException ex) {
              }
        }
    
}
