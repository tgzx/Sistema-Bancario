import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBanco[] contaBanco = new ContaBanco[3];
        boolean loopMenu = true;
        while (loopMenu){
            ContaBanco.menu1();
            String res = scanner.next();
            if (res.equals("1")){
                try {
                    System.out.println("Digite o numero da conta: ");
                    int numConta = scanner.nextInt();
                    if (contaBanco[numConta-1] != null && contaBanco[numConta-1].isStatus()){
                        System.out.println("\n*********************************\nConta selecionada: ");
                        contaBanco[numConta-1].info();
                        System.out.println("*********************************\n\nValor de saque: ");
                        float valorSaque = scanner.nextFloat();
                        System.out.println("\n****** OPERACAO REALIZADA ******* ");
                        contaBanco[numConta-1].sacar(valorSaque);
                        System.out.println("\n*********************************\n");
                    } else {
                        System.out.println("Conta não existe.\n");
                    }
                } catch (Exception e){
                    System.out.println("Sua resposta difere da informacao solicitada!\n");
                }
            } else if (res.equals("2")){
                try {
                    System.out.println("Digite o numero da conta: ");
                    int numConta = scanner.nextInt();
                    if (contaBanco[numConta-1] != null && contaBanco[numConta-1].isStatus()){
                        System.out.println("\n*********************************\nConta selecionada: ");
                        contaBanco[numConta-1].info();
                        System.out.println("*********************************\n\nValor de deposito: ");
                        float valorDeposito = scanner.nextFloat();
                        System.out.println("\n****** OPERACAO REALIZADA ******* ");
                        contaBanco[numConta-1].depositar(valorDeposito);
                        System.out.println("\n*********************************\n");
                    } else {
                        System.out.println("Conta não existe.\n");
                    }
                } catch (Exception e){
                    System.out.println("Sua resposta difere da informacao solicitada!\n");
                }
            } else if (res.equals("3")){
                try {
                    System.out.println("Digite seu nome completo:");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    System.out.println("CC ou CP:");
                    String tipoConta = scanner.next();
                    System.out.println("Numero da conta: ");
                    int i = scanner.nextInt() - 1;
                    contaBanco[i] = new ContaBanco(nome, tipoConta, i);
                    System.out.println(" ");
                } catch (Exception e){
                    System.out.println("Sua resposta difere da informacao solicitada!\n");
                }
            } else if (res.equals("4")){
                try {
                    System.out.println("Digite o numero da conta: ");
                    int numConta = scanner.nextInt();
                    contaBanco[numConta-1].fecharConta();
                } catch (Exception e){
                    System.out.println("Sua resposta difere da informacao solicitada!\n");
                }
            } else if (res.equals("5")){
                try {
                    int contNull = 0;
                    for (int i = 0; i < contaBanco.length; i++) {
                        if (contaBanco[i] == null){
                            System.out.println(" ");
                            contNull++;
                        }
                    }
                    System.out.println("\n****************************************\n" +
                            "Quantidade de slots para cadastro: " + contaBanco.length +
                            "\n Quantidade de slots preenchidos: " +(contaBanco.length - contNull) +
                            "\n Quantidade de slots vazios: " + contNull +
                            "\n****************************************\n");
                    for (int i = 0; i < contaBanco.length; i++) {
                        contaBanco[i].info();
                    }
                } catch (Exception e){
                    System.out.println(" ");
                }
            } else if (res.equals("6")) {
                loopMenu = false;
            } else {
                System.out.println("Selecione apenas as opcoes citadas...\n");
            }
        }
    }
}